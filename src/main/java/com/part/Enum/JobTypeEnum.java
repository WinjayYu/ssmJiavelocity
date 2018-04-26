package com.part.Enum;

public enum JobTypeEnum {

	PART_TIME(1, "兼职"),
	FULL_TIME(2, "全职"),
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

	private JobTypeEnum(Integer type, String remark) {
		this.type = type;
		this.remark = remark;
	}
	
}
