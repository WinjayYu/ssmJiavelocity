package com.part.service;

import java.util.List;

import com.part.entity.ApiResult;
import com.part.entity.JobEntity;
import com.part.vo.PageVO;

public interface JobService {
	
    /**
     * 分页获取职位列表
     * @return
     */
	public ApiResult listJob(PageVO pager);
	
	/**
	 * 根据条件分页获取职位列表
	 * @param entity
	 * @return
	 */
	public ApiResult listJobByEntity(JobEntity entity, PageVO pager);
	
	/**
	 * 根据职位id查看职位详情
	 * @param jobId
	 * @return
	 */
	public ApiResult getJobDetail(Long jobId);
	
	public ApiResult getNewJobs();

	/**
	 * 删除职位
	 * @param id
	 * @return
	 */
	public ApiResult deleteJob(Long id);
	
	/**
	 * 发布职位
	 * @param job
	 * @return
	 */
	public ApiResult publish(JobEntity job);
	
}
