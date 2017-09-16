package me.wuwenbin.items.campustalk.crawler.pipeline;

import me.wuwenbin.items.campustalk.crawler.support.JxufeDetailPage;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

public class JxufePipeline implements Pipeline {

    private JxufeDetailPage result;


    @Override
    public void process(ResultItems resultItems, Task task) {
        result.setCompanyIntro(resultItems.get("companyIntro"));
        result.setRecruitment(resultItems.get("recruitment"));
        result.setJobs(resultItems.get("jobs"));
    }

    public void setResult(JxufeDetailPage result) {
        this.result = result;
    }

    public JxufeDetailPage getResult() {
        return this.result;
    }
}
