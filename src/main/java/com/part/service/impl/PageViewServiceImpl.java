package com.part.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.part.dao.PageViewDAO;
import com.part.dataobject.PageViewDO;
import com.part.dataobject.PageViewDOExample;
import com.part.entity.ApiResult;
import com.part.entity.PageViewEntity;
import com.part.service.PageViewService;
import com.part.utils.ResultUtils;
@Service
public class PageViewServiceImpl implements PageViewService {

	@Resource
	private PageViewDAO viewDAO;
	
	@Override
	public ApiResult addCount(Long jobId) {
		PageViewEntity entity = new PageViewEntity();
		entity.setJobId(jobId);
		entity.setCount(1);
		entity.setGmtCreated(new Date());
		entity.setGmtModified(new Date());
		PageViewDO po = this.entity2do(entity);
		viewDAO.insertSelective(po);
		return ResultUtils.setOk();
	}

	private PageViewDO entity2do(PageViewEntity entity) {
		PageViewDO po = new PageViewDO();
		BeanUtils.copyProperties(entity, po);
		return po;
	}

	@Override
	public ApiResult searchCount(Long jobId) {
		PageViewDOExample example = new PageViewDOExample();
		example.createCriteria().andJobIdEqualTo(jobId);
		long count = viewDAO.countByExample(example);
		return ResultUtils.setOk(count);
	}

}
