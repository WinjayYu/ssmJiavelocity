package com.part.dataobject;

import java.util.Date;

public class JobDO {
    private Long id;

    private Integer type;

    private Long userId;

    private String title;

    private Integer lessSalary;

    private Integer mastSalary;

    private Integer salaryType;

    private Integer needPeople;

    private String lessEducation;

    private String lessExperience;

    private String mastExperience;

    private Integer lessAge;

    private Integer mastAge;

    private String adress;

    private Long telphone;

    private String connectUser;

    private String company;

    private String companyDetail;

    private Long categoryId;

    private String detail;

    private String requestLimit;

    private Date gmtCreated;

    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getLessSalary() {
        return lessSalary;
    }

    public void setLessSalary(Integer lessSalary) {
        this.lessSalary = lessSalary;
    }

    public Integer getMastSalary() {
        return mastSalary;
    }

    public void setMastSalary(Integer mastSalary) {
        this.mastSalary = mastSalary;
    }

    public Integer getSalaryType() {
        return salaryType;
    }

    public void setSalaryType(Integer salaryType) {
        this.salaryType = salaryType;
    }

    public Integer getNeedPeople() {
        return needPeople;
    }

    public void setNeedPeople(Integer needPeople) {
        this.needPeople = needPeople;
    }

    public String getLessEducation() {
        return lessEducation;
    }

    public void setLessEducation(String lessEducation) {
        this.lessEducation = lessEducation == null ? null : lessEducation.trim();
    }

    public String getLessExperience() {
        return lessExperience;
    }

    public void setLessExperience(String lessExperience) {
        this.lessExperience = lessExperience == null ? null : lessExperience.trim();
    }

    public String getMastExperience() {
        return mastExperience;
    }

    public void setMastExperience(String mastExperience) {
        this.mastExperience = mastExperience == null ? null : mastExperience.trim();
    }

    public Integer getLessAge() {
        return lessAge;
    }

    public void setLessAge(Integer lessAge) {
        this.lessAge = lessAge;
    }

    public Integer getMastAge() {
        return mastAge;
    }

    public void setMastAge(Integer mastAge) {
        this.mastAge = mastAge;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress == null ? null : adress.trim();
    }

    public Long getTelphone() {
        return telphone;
    }

    public void setTelphone(Long telphone) {
        this.telphone = telphone;
    }

    public String getConnectUser() {
        return connectUser;
    }

    public void setConnectUser(String connectUser) {
        this.connectUser = connectUser == null ? null : connectUser.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getCompanyDetail() {
        return companyDetail;
    }

    public void setCompanyDetail(String companyDetail) {
        this.companyDetail = companyDetail == null ? null : companyDetail.trim();
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getRequestLimit() {
        return requestLimit;
    }

    public void setRequestLimit(String requestLimit) {
        this.requestLimit = requestLimit == null ? null : requestLimit.trim();
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}