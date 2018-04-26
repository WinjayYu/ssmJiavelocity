package com.part.service;

import com.part.entity.ApiResult;
import com.part.entity.PageViewEntity;

public interface PageViewService {

	/**
	 * 记录访问量
	 * @param entity
	 * @return
	 */
	public ApiResult addCount(Long jobId);
	
	/**
	 * 查询职位的访问量
	 * @param jobId
	 * @return
	 */
	public ApiResult searchCount(Long jobId);
}
