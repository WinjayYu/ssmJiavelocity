package com.part.entity;

import java.io.Serializable;

public class ContactUsEntity implements Serializable{

	private static final long serialVersionUID = -5392568726948453701L;

	private String content;
	
	private Long userId;
	
	private Long id;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
