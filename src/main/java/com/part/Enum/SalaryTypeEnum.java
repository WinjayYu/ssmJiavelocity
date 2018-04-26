package com.part.Enum;

public enum SalaryTypeEnum {

	HOUR(1, "小时"),
	DAY(2, "天"),
	MONTH(3, "月"),
	YEAR(4, "年"),
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

	private SalaryTypeEnum(Integer type, String remark) {
		this.type = type;
		this.remark = remark;
	}
	
}
