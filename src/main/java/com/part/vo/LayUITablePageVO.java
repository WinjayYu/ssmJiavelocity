package com.part.vo;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

public class LayUITablePageVO implements Serializable{

	private static final long serialVersionUID = -1057124520799313098L;

	private Integer code;
	
	private String msg;
	
	private Long count;
	
	private Object data;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
	
	
}
