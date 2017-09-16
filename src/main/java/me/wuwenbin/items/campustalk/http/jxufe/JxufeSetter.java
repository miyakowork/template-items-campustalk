package me.wuwenbin.items.campustalk.http.jxufe;

import jodd.json.JsonParser;
import me.wuwenbin.items.campustalk.crawler.pipeline.JxufePipeline;
import me.wuwenbin.items.campustalk.crawler.processor.JxufePageProcessor;
import me.wuwenbin.items.campustalk.crawler.support.JxufeDetailPage;
import me.wuwenbin.items.campustalk.entity.Jxufe;
import me.wuwenbin.items.campustalk.entity.base.Job;
import me.wuwenbin.items.campustalk.http.jxufe.support.JxufeBo;
import me.wuwenbin.items.campustalk.http.jxufe.support.JxufeResult;
import me.wuwenbin.items.campustalk.http.jxufe.support.R;
import me.wuwenbin.items.campustalk.util.HttpClientUtil;
import us.codecraft.webmagic.Spider;

import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * HTTP请求获取宣讲会列表信息以及详细页面的一起爬取
 */
public class JxufeSetter {

    /**
     * 获取http请求的数据
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    private static List<JxufeBo> getHttpData(int pageNo, int pageSize) {
        String url = "http://career.jxufe.edu.cn/module/getcareers";
        Map<String, Object> params = new HashMap<>();
        params.put("start_page", 1);
        params.put("type", "inner");
        params.put("count", pageSize);
        params.put("start", pageNo);
        params.put("day", "");
        String s;
        try {
            s = HttpClientUtil.httpGetRequest(url, params);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            s = "";
        }
        JsonParser jsonParser = new JsonParser();
        R result = jsonParser.parse(s, R.class);
        return result.getData();
    }


    /**
     * 获取当前页的所有宣讲会信息包括宣讲会中的所有招聘岗位
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    public static JxufeResult getJxufeResult(int pageNo, int pageSize) {
        List<JxufeBo> resultBos = getHttpData(pageNo, pageSize);
        List<Jxufe> talks = new ArrayList<>();
        List<Job> allJobs = new LinkedList<>();
        JxufeResult jxufeResult = new JxufeResult();
        for (JxufeBo resultBo : resultBos) {
            Jxufe talk = new Jxufe();
            talk.setCompanyLogo(resultBo.getLogo());
            talk.setCareerTalkId(resultBo.getCareer_talk_id());
            talk.setCompanyName(resultBo.getCompany_name());
            talk.setCompanyProperty(resultBo.getCompany_property());
            talk.setIndustryCategory(resultBo.getIndustry_category());
            talk.setCampusTalkAddr(resultBo.getAddress());
            talk.setUniversity(resultBo.getSchool_name());
            try {
                talk.setTalkDatetime(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(resultBo.getMeet_day() + " " + resultBo.getMeet_time()));
            } catch (ParseException e) {
                e.printStackTrace();
                talk.setTalkDatetime(null);
            }

            JxufePipeline jxufePipeline = new JxufePipeline();
            Spider.create(new JxufePageProcessor(resultBo.getCareer_talk_id()))
                    .addUrl("http://career.jxufe.edu.cn/detail/career?id=" + resultBo.getCareer_talk_id())
                    .addPipeline(jxufePipeline)
                    .thread(5)
                    .run();
            JxufeDetailPage result = jxufePipeline.getResult();
            talk.setCompanyIntro(result.getCompanyIntro());
            talk.setRecruitment(result.getRecruitment());
            talks.add(talk);
            allJobs.addAll(result.getJobs());
        }
        jxufeResult.setTalksInJxufe(talks);
        jxufeResult.setJobsInJxufe(allJobs);
        return jxufeResult;
    }


}
