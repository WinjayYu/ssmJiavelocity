package com.part.Enum;

public enum UserSexEnum {

	MAIL(1 , "男"),
	FEMAIL(2 , "女"),
	;
	
	public Integer type;
	
	public String remark;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	private UserSexEnum(Integer type, String remark) {
		this.type = type;
		this.remark = remark;
	}
	
}
