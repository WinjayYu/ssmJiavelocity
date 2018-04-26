package com.part.utils;

import com.part.Enum.ResultCode;
import com.part.entity.ApiResult;

public class ResultUtils {
	public static ApiResult setError(ResultCode resultCode) {
        return setError(null,resultCode);
    }
    
    public static ApiResult setError(ApiResult apiResult,ResultCode resultCode) {
        if(apiResult == null) {
            apiResult = new ApiResult();
        }
        apiResult.setError(resultCode.getMessage());
        apiResult.setCode(resultCode.getCode());
        apiResult.setSuccess(false);
        
        return apiResult;
    }
    
    public static ApiResult setError(int code, String message) {
        
        ApiResult apiResult = new ApiResult();
        apiResult.setError(message);
        apiResult.setCode(code);
        apiResult.setSuccess(false);
        
        return apiResult;
    }
    
    public static ApiResult setError(ResultCode resultCode,String message) {
        return setError(null,resultCode,message);
    }
    
    public static ApiResult setError(ApiResult apiResult,ResultCode resultCode,String message) {
        if(apiResult == null) {
            apiResult = new ApiResult();
        }
        apiResult.setError(String.format(resultCode.getMessage(),message));
        apiResult.setCode(resultCode.getCode());
        apiResult.setSuccess(false);
        
        return apiResult;
    }
    
    public static ApiResult setOk() {
        return setOk(null);
    }
    
    public static ApiResult setOk(ApiResult apiResult) {
        if(apiResult == null) {
            apiResult = new ApiResult();
        }
        apiResult.setData(null);
        apiResult.setSuccess(true);
        apiResult.setCode(ResultCode.SUCCESS.getCode());
        
        return apiResult;
    }
    
    public static ApiResult setOk(Object data) {
        return setOk(null, data);
    }
    
    public static ApiResult setOk(ApiResult apiResult,Object data) {
        if(apiResult == null) {
            apiResult = new ApiResult();
        }
        apiResult.setData(data);
        apiResult.setSuccess(true);
        apiResult.setCode(ResultCode.SUCCESS.getCode());
        
        return apiResult;
    }
    
    public static boolean isFailure(ApiResult apiResult) {
        return !apiResult.isSuccess();
    }
    
}
