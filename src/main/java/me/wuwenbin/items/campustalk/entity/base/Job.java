package me.wuwenbin.items.campustalk.entity.base;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Job {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "talk_id")
    private String talkId;//宣讲会id
    private String title;//职位名称
    private String major;//专业
    private String salary;//薪资
    private String people;//人数
    private String education_addr;//学历和工作地点

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTalkId() {
        return talkId;
    }

    public void setTalkId(String talkId) {
        this.talkId = talkId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getEducation_addr() {
        return education_addr;
    }

    public void setEducation_addr(String education_addr) {
        this.education_addr = education_addr;
    }
}