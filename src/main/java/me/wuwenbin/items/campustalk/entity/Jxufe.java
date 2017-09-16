package me.wuwenbin.items.campustalk.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "talk_jxufe")
public class Jxufe {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "company_logo")
    private String companyLogo;
    @Column(name = "career_talk_id")
    private String careerTalkId;//宣讲会ID
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "company_property")
    private String companyProperty;//公司类型：国有企业
    @Column(name = "industry_category")
    private String industryCategory;//企业类型：建筑业
    @Column(name = "campus_talk_addr")
    private String campusTalkAddr;
    @Column
    private String university;
    @Column(name = "talk_datetime")
    private Date talkDatetime;
    @Column
    private String recruitment;//招聘简章
    @Column
    private String companyIntro;//公司简介


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    public String getCareerTalkId() {
        return careerTalkId;
    }

    public void setCareerTalkId(String careerTalkId) {
        this.careerTalkId = careerTalkId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyProperty() {
        return companyProperty;
    }

    public void setCompanyProperty(String companyProperty) {
        this.companyProperty = companyProperty;
    }

    public String getIndustryCategory() {
        return industryCategory;
    }

    public void setIndustryCategory(String industryCategory) {
        this.industryCategory = industryCategory;
    }

    public String getCampusTalkAddr() {
        return campusTalkAddr;
    }

    public void setCampusTalkAddr(String campusTalkAddr) {
        this.campusTalkAddr = campusTalkAddr;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public Date getTalkDatetime() {
        return talkDatetime;
    }

    public void setTalkDatetime(Date talkDatetime) {
        this.talkDatetime = talkDatetime;
    }

    public String getRecruitment() {
        return recruitment;
    }

    public void setRecruitment(String recruitment) {
        this.recruitment = recruitment;
    }

    public String getCompanyIntro() {
        return companyIntro;
    }

    public void setCompanyIntro(String companyIntro) {
        this.companyIntro = companyIntro;
    }
}
