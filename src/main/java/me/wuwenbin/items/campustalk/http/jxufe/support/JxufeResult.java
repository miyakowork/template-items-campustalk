package me.wuwenbin.items.campustalk.http.jxufe.support;

import me.wuwenbin.items.campustalk.entity.Jxufe;
import me.wuwenbin.items.campustalk.entity.base.Job;

import java.util.List;

public class JxufeResult {
    private List<Jxufe> talksInJxufe;
    private List<Job> jobsInJxufe;

    public List<Jxufe> getTalksInJxufe() {
        return talksInJxufe;
    }

    public void setTalksInJxufe(List<Jxufe> talksInJxufe) {
        this.talksInJxufe = talksInJxufe;
    }

    public List<Job> getJobsInJxufe() {
        return jobsInJxufe;
    }

    public void setJobsInJxufe(List<Job> jobsInJxufe) {
        this.jobsInJxufe = jobsInJxufe;
    }
}
