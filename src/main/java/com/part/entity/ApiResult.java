package com.part.entity;

import java.io.Serializable;

public class ApiResult implements Serializable{

	private static final long serialVersionUID = 5645895219138275201L;

	private boolean isSuccess = true;
	private Object data;
	private String error;
	private int code = 200;

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public boolean isSuccess() {
		return this.isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public Object getData() {
		return this.data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getError() {
		return this.error;
	}

	public void setError(String error) {
		this.isSuccess = false;
		this.error = error;
	}

	public void setError(int code, String errorMsg) {
		this.error = errorMsg;
		this.code = code;
		this.isSuccess = false;
	}

	public void setError(int code, String format, String errorMsg) {
		this.error = String.format(format, new Object[]{errorMsg});
		this.code = code;
		this.isSuccess = false;
	}
	
}
