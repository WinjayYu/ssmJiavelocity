package com.part.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.part.Enum.ResultCode;
import com.part.dao.ResumeDAO;
import com.part.dataobject.ResumeDO;
import com.part.dataobject.ResumeDOExample;
import com.part.dataobject.ResumeDOExample.Criteria;
import com.part.entity.ApiResult;
import com.part.entity.ResumeEntity;
import com.part.service.ResumeService;
import com.part.utils.ResultUtils;
import com.part.vo.PageVO;
@Service
public class ResumeServiceImpl implements ResumeService {

	@Resource
	private ResumeDAO resumeDAO;
	
	@SuppressWarnings("unchecked")
	@Override
	public ApiResult resumeJob(ResumeEntity entity) {
		List<ResumeEntity> entityList = (List<ResumeEntity>) findByUserIdAndJobId(entity.getUserId(), entity.getJobId()).getData();
		if (entityList != null && !entityList.isEmpty()) {
			return ResultUtils.setError(ResultCode.ALREADY_RESUME);
		}
		entity.setGmtCreated(new Date());
		entity.setGmtModified(new Date());
		ResumeDO po = this.entity2do(entity);
		resumeDAO.insertSelective(po);
		return ResultUtils.setOk();
	}

	private ResumeDO entity2do(ResumeEntity entity) {
		ResumeDO po = new ResumeDO();
		BeanUtils.copyProperties(entity, po);
		return po;
	}

	@Override
	public ApiResult countForJob(Long jobId) {
		ResumeDOExample example = new ResumeDOExample();
		example.createCriteria().andJobIdEqualTo(jobId);
		long count = resumeDAO.countByExample(example);
		return ResultUtils.setOk(count);
	}

	@Override
	public ApiResult countForUser(Long userId) {
		ResumeDOExample example = new ResumeDOExample();
		example.createCriteria().andUserIdEqualTo(userId);
		long count = resumeDAO.countByExample(example);
		return ResultUtils.setOk(count);
	}

	@Override
	public ApiResult listForUser(Long userId) {
		ResumeDOExample example = new ResumeDOExample();
		example.createCriteria().andUserIdEqualTo(userId);
		List<ResumeDO> poList = resumeDAO.selectByExample(example);
		List<ResumeEntity> entityList = new ArrayList<>();
		for (ResumeDO po : poList) {
			entityList.add(this.do2entity(po));
		}
		return ResultUtils.setOk(entityList);
	}

	private ResumeEntity do2entity(ResumeDO po) {
		ResumeEntity entity = new ResumeEntity();
		BeanUtils.copyProperties(po, entity);
		return entity;
	}

	@Override
	public ApiResult listAll(ResumeEntity entity, PageVO pager) {
		ResumeDOExample example = new ResumeDOExample();
		if (pager == null) {
			pager = new PageVO();
		}
		example.setPage(pager);
		example.setOrderByClause("gmt_created desc");
		Criteria criteria = example.createCriteria();
		if (entity.getJobId() != null) {
			criteria.andJobIdEqualTo(entity.getJobId());
		}
		if (entity.getId() != null) {
			criteria.andIdEqualTo(entity.getId());
		}
		if (entity.getUserId() != null) {
			criteria.andUserIdEqualTo(entity.getUserId());
		}
		long count = resumeDAO.countByExample(example);
		List<ResumeDO> poList = resumeDAO.selectByExample(example);
		List<ResumeEntity> entityList = new ArrayList<>();
		for (ResumeDO po : poList) {
			entityList.add(this.do2entity(po));
		}
		pager.setData(entityList);
		pager.setTotalCount(count);
		return ResultUtils.setOk(pager);
	}

	public ApiResult findByUserIdAndJobId(Long userId, Long jobId){
		if (userId == null) {
			return ResultUtils.setError(ResultCode.NOT_LOGIN);
		}
		ResumeDOExample example = new ResumeDOExample();
		example.createCriteria().andUserIdEqualTo(userId).andJobIdEqualTo(jobId);
		List<ResumeDO> poList = resumeDAO.selectByExample(example);
		List<ResumeEntity> entityList = new ArrayList<>();
		for (ResumeDO po : poList) {
			entityList.add(this.do2entity(po));
		}
		return ResultUtils.setOk(entityList);
	}
	
}
