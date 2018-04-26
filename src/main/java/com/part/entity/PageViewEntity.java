package com.part.entity;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.JSON;

public class PageViewEntity implements Serializable{

	private static final long serialVersionUID = 5720669681268021235L;

	private Long id;

    private Long jobId;

    private Integer count;

    private Date gmtCreated;

    private Date gmtModified;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
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

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
    
}
