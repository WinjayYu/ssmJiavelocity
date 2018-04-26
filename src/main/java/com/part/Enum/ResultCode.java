package com.part.Enum;

public enum ResultCode {
	
	SUCCESS(200, "sucessful"), 
	
	UNKNOWN_ERROR(500,"unknown error"),
	DATA_NOT_FOUND(501,"data not found"),
	
	PARAM_NULL(1001, "参数 [%s] 为空"),
	LOGIN_FAILED(1002, "登录失败"),
	REGIST_FAILED(1003, "注册失败"),
	USERNAME_EXIST(1004, "用户名已存在"),
	UPDATE_FAILED(1005, "更新失败"),
	ALREADY_RESUME(1006, "已经申请过"),
	NOT_LOGIN(1007, "未登录"),
	;
	private int code;
	private String message;

	private ResultCode(int code, String msg) {
		this.code = code;
		this.message = msg;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public boolean isSuccess() {
		return this.code == 200;
	}

	public static ResultCode valueOf(int code) {
		for (ResultCode value : values()) {
			if (code == value.code) {
				return value;
			}
		}

		return SUCCESS; // default is successful
	}
}
