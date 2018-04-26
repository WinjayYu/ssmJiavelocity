package com.part.entity;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.JSON;

public class JobEntity implements Serializable{

	private static final long serialVersionUID = 2163251194565703876L;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
		this.lessEducation = lessEducation;
	}

	public String getLessExperience() {
		return lessExperience;
	}

	public void setLessExperience(String lessExperience) {
		this.lessExperience = lessExperience;
	}

	public String getMastExperience() {
		return mastExperience;
	}

	public void setMastExperience(String mastExperience) {
		this.mastExperience = mastExperience;
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
		this.adress = adress;
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
		this.connectUser = connectUser;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCompanyDetail() {
		return companyDetail;
	}

	public void setCompanyDetail(String companyDetail) {
		this.companyDetail = companyDetail;
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
		this.detail = detail;
	}

	public String getRequestLimit() {
		return requestLimit;
	}

	public void setRequestLimit(String requestLimit) {
		this.requestLimit = requestLimit;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
    
}
