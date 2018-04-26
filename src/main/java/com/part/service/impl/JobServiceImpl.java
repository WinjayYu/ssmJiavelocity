package com.part.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.part.Enum.ResultCode;
import com.part.dao.JobDAO;
import com.part.dataobject.JobDO;
import com.part.dataobject.JobDOExample;
import com.part.dataobject.JobDOExample.Criteria;
import com.part.entity.ApiResult;
import com.part.entity.JobEntity;
import com.part.service.JobService;
import com.part.utils.ResultUtils;
import com.part.vo.PageVO;
@Service
public class JobServiceImpl implements JobService {
	
	@Resource
	private JobDAO jobDAO;

	/**
	 * 分页查询职位
	 */
	@Override
	public ApiResult listJob(PageVO pager) {
		JobDOExample example = new JobDOExample();
		//设置排序，按时间倒序
		example.setOrderByClause("gmt_created");
	    if (pager != null) {
	    	//设置分页
	    	example.setPage(pager);
	    } else {
	    	pager = new PageVO();
	    }
	    //计算数据条数
	    long count = jobDAO.countByExample(example);
	    List<JobEntity> entityList = new ArrayList<>();
	    //获取职位集合
	    List<JobDO> poList = jobDAO.selectByExample(example);
	    for (JobDO po : poList) {
	    	//do转entity
	    	entityList.add(this.do2entity(po));
	    }
	    //将数据设置进PageVO分页实体
	    if (pager != null) {
            pager.setData(entityList);
            pager.setTotalCount(count);
        }
	    //返回分页实体
	  	return ResultUtils.setOk(pager);
	}

	/**
	 * do转entity
	 * @param po
	 * @return
	 */
	private JobEntity do2entity(JobDO po) {
		JobEntity entity = new JobEntity();
		BeanUtils.copyProperties(po, entity);
		return entity;
	}

	@Override
	public ApiResult listJobByEntity(JobEntity entity, PageVO pager) {
		JobDOExample example = new JobDOExample();
		//设置排序，按时间倒序
		example.setOrderByClause("gmt_created desc");
	    if (pager != null) {
	    	//设置分页
	    	example.setPage(pager);
	    } else {
	    	pager = new PageVO();
	    }
	    Criteria criteria = example.createCriteria();
	    if (StringUtils.isNotBlank(entity.getTitle())) {
	    	criteria.andTitleLike("%" + entity.getTitle() + "%");
	    }
	    if (StringUtils.isNotBlank(entity.getAdress())) {
	    	criteria.andAdressLike("%" + entity.getAdress() + "%");
	    }
	    if (StringUtils.isNotBlank(entity.getCompany())) {
	    	criteria.andCompanyLike("%" + entity.getCompany() + "%");
	    }
	    if (entity.getType() != null) {
	    	criteria.andTypeEqualTo(entity.getType());
	    }
	    if (entity.getCategoryId() != null) {
	    	criteria.andCategoryIdEqualTo(entity.getCategoryId());
	    }
	    if (entity.getUserId() != null) {
	    	criteria.andUserIdEqualTo(entity.getUserId());
	    }
	    long count = jobDAO.countByExample(example);
	    List<JobEntity> entityList = new ArrayList<>();
	    //获取职位集合
	    List<JobDO> poList = jobDAO.selectByExample(example);
	    for (JobDO po : poList) {
	    	//do转entity
	    	entityList.add(this.do2entity(po));
	    }
	    //将数据设置进PageVO分页实体
	    if (pager != null) {
            pager.setData(entityList);
            pager.setTotalCount(count);
        } 
	    //返回分页实体
	  	return ResultUtils.setOk(pager);
	}

	@Override
	public ApiResult getJobDetail(Long jobId) {
		if (jobId == null) {
			return ResultUtils.setError(ResultCode.PARAM_NULL, "jobId");
		}
		JobDO po = jobDAO.selectByPrimaryKey(jobId);
		return ResultUtils.setOk(this.do2entity(po));
	}

	@Override
	public ApiResult getNewJobs() {
		JobDOExample example = new JobDOExample();
		PageVO pager = new PageVO();
		example.setOrderByClause("gmt_created");
		example.setPage(pager);
		List<JobDO> poList = jobDAO.selectByExample(example);
		List<JobEntity> entityList = new ArrayList<>();
		for (JobDO po : poList) {
			entityList.add(this.do2entity(po));
		}
		return ResultUtils.setOk(entityList);
	}

	@Override
	public ApiResult deleteJob(Long id) {
		jobDAO.deleteByPrimaryKey(id);
		return ResultUtils.setOk();
	}

	@Override
	public ApiResult publish(JobEntity job) {
		Date now = new Date();
		job.setGmtCreated(now);
		job.setGmtModified(now);
		int line = jobDAO.insertSelective(this.entity2do(job));
		if (line < 1) {
			return ResultUtils.setError(ResultCode.DATA_NOT_FOUND);
		}
		
		return ResultUtils.setOk();
	}

	private JobDO entity2do(JobEntity job) {
		JobDO po = new JobDO();
		BeanUtils.copyProperties(job, po);
		return po;
	}

}
