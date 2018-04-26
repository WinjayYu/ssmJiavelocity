package com.part.Enum;

public enum UserTypeEnum {

	USER(1, "普通会员"),
	RECRUIT(2, "招聘方"),
	ADMIN(3, "管理员"),
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

	private UserTypeEnum(Integer type, String remark) {
		this.type = type;
		this.remark = remark;
	}
	
}
