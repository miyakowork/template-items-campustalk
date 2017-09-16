package me.wuwenbin.items.campustalk.crawler.support;

import me.wuwenbin.items.campustalk.entity.base.Job;

import java.util.List;

public class JxufeDetailPage {

    private String companyIntro;
    private String recruitment;
    private List<Job> jobs;

    public String getCompanyIntro() {
        return companyIntro;
    }

    public void setCompanyIntro(String companyIntro) {
        this.companyIntro = companyIntro;
    }

    public String getRecruitment() {
        return recruitment;
    }

    public void setRecruitment(String recruitment) {
        this.recruitment = recruitment;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}
