package com.part.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.part.Enum.ResultCode;
import com.part.dao.NewsDAO;
import com.part.dataobject.NewsDO;
import com.part.dataobject.NewsDOExample;
import com.part.dataobject.NewsDOExample.Criteria;
import com.part.entity.ApiResult;
import com.part.entity.NewsEntity;
import com.part.service.NewsService;
import com.part.utils.ResultUtils;
import com.part.vo.PageVO;
@Service
public class NewsServiceImpl implements NewsService {

	@Resource
	private NewsDAO newsDAO;
	
	@Override
	public ApiResult createNews(NewsEntity entity) {
		if (entity == null) {
			return ResultUtils.setError(ResultCode.PARAM_NULL);
		}
		if (StringUtils.isBlank(entity.getPicUrl())) {
			return ResultUtils.setError(ResultCode.PARAM_NULL, "picUrl");
		}
		Date now = new Date();
		entity.setGmtCreated(now);
		entity.setGmtModified(now);
		NewsDO po = this.entity2do(entity);
		int line = newsDAO.insertSelective(po);
		if (line < 1) {
			return ResultUtils.setError(ResultCode.UPDATE_FAILED);
		}
		return ResultUtils.setOk();
	}

	private NewsDO entity2do(NewsEntity entity) {
		NewsDO po = new NewsDO();
		BeanUtils.copyProperties(entity, po);
		return po;
	}

	@Override
	public ApiResult listByEntity(NewsEntity entity, PageVO pager) {
		if (entity == null) {
			entity = new NewsEntity();
		}
		NewsDOExample example = new NewsDOExample();
		example.setOrderByClause("gmt_created");
		if (pager == null) {
			pager = new PageVO();
		}
		Criteria criteria = example.createCriteria();
		example.setPage(pager);
		if (StringUtils.isNotBlank(entity.getTitle())) {
			criteria.andTitleEqualTo(entity.getTitle());
		}
		if (entity.getCreatedId() != null) {
			criteria.andCreatedIdEqualTo(entity.getCreatedId());
		}
		
		long count = newsDAO.countByExample(example);
		List<NewsDO> poList = newsDAO.selectByExample(example);
		List<NewsEntity> entityList = new ArrayList<>();
		for (NewsDO po : poList) {
			entityList.add(this.do2entity(po));
		}
		pager.setData(entityList);
		pager.setTotalCount(count);
		return ResultUtils.setOk(pager);
	}

	private NewsEntity do2entity(NewsDO po) {
		NewsEntity entity = new NewsEntity();
		BeanUtils.copyProperties(po, entity);
		return entity;
	}

	@Override
	public ApiResult deleteByIds(List<Long> ids) {
		if (ids == null || ids.isEmpty()) {
			return ResultUtils.setError(ResultCode.PARAM_NULL);
		}
		for (Long id : ids) {
			int line = newsDAO.deleteByPrimaryKey(id);
			if (line < 1) {
				return ResultUtils.setError(ResultCode.UPDATE_FAILED);
			}
		}
		return ResultUtils.setOk();
	}

}
