package com.part.service;

import com.part.entity.ApiResult;
import com.part.entity.ResumeEntity;
import com.part.vo.PageVO;

public interface ResumeService {

	/**
	 * 申请职位
	 * @param entity
	 * @return
	 */
	public ApiResult resumeJob(ResumeEntity entity);
	
	/**
	 * 职位申请的数量
	 * @param jobId
	 * @return
	 */
	public ApiResult countForJob(Long jobId);
	
	/**
	 * 用户申请职位的数量
	 * @param userId
	 * @return
	 */
	public ApiResult countForUser(Long userId);
	
	/**
	 * 用户申请职位列表
	 * @param userId
	 * @return
	 */
	public ApiResult listForUser(Long userId);
	
	/**
	 * 按条件分页查询职位申请列表
	 * @param entity
	 * @param pager
	 * @return
	 */
	public ApiResult listAll(ResumeEntity entity, PageVO pager);
}
