package me.wuwenbin.items.campustalk.crawler.processor;

import me.wuwenbin.items.campustalk.entity.base.Job;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;

public class JxufePageProcessor implements PageProcessor {


    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    private String talkId;

    public JxufePageProcessor(String talkId) {
        this.talkId = talkId;
    }

    @Override
    public void process(Page page) {
        String companyIntro = page.getHtml().xpath("//div[@class='detail-module'][2]/div[@class='dm-cont']/text()").get();
        page.putField("companyIntro", companyIntro);
        String recruitment = page.getHtml().xpath("//div[@class='detail-module'][3]/div[@class='dm-cont']/html()").get();
        page.putField("recruitment", recruitment);
        List<String> jobNames = page.getHtml().xpath("//div[@class='detail-module'][4]/div[@class='dm-cont pub-list']/div[@class='clearfix dm-text']/div[1]/p[1]/a[@class='item-link']/text()").all();
        List<String> jobMajor = page.getHtml().xpath("//div[@class='detail-module'][4]/div[@class='dm-cont pub-list']/div[@class='clearfix dm-text']/div[1]/p[2]/text()").all();
        List<String> jobSalary = page.getHtml().xpath("//div[@class='detail-module'][4]/div[@class='dm-cont pub-list']/div[@class='clearfix dm-text']/div[2]/text()").all();
        List<String> jobPeople = page.getHtml().xpath("//div[@class='detail-module'][4]/div[@class='dm-cont pub-list']/div[@class='clearfix dm-text']/div[3]/p[1]/text()").all();
        List<String> jobConditions = page.getHtml().xpath("//div[@class='detail-module'][4]/div[@class='dm-cont pub-list']/div[@class='clearfix dm-text']/div[3]/p[2]/text()").all();
        List<Job> jobs = new ArrayList<>(jobNames.size());
        for (int i = 0; i < jobNames.size(); i++) {
            Job job = new Job();
            job.setTitle(jobNames.get(i));
            job.setMajor(jobMajor.get(i));
            job.setSalary(jobSalary.get(i));
            job.setPeople(jobPeople.get(i));
            job.setEducation_addr(jobConditions.get(i));
            job.setTalkId(talkId);
            jobs.add(job);
        }
        page.putField("jobs", jobs);
    }

    @Override
    public Site getSite() {
        return site;
    }

}