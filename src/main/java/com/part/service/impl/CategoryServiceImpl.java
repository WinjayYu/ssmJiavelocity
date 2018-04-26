package com.part.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.part.Enum.ResultCode;
import com.part.dao.CategoryDAO;
import com.part.dataobject.CategoryDO;
import com.part.dataobject.CategoryDOExample;
import com.part.entity.ApiResult;
import com.part.entity.CategoryEntity;
import com.part.service.CategoryService;
import com.part.utils.ResultUtils;
import com.part.vo.PageVO;
@Service
public class CategoryServiceImpl implements CategoryService {

	@Resource
	private CategoryDAO categoryDAO;
	
	@Override
	public ApiResult createCategory(CategoryEntity entity) {
		if (entity.getLevel() == null) {
			return ResultUtils.setError(ResultCode.PARAM_NULL,"级别");
		}
		if (StringUtils.isBlank(entity.getName())) {
			return ResultUtils.setError(ResultCode.PARAM_NULL,"名称");
		}
		if (entity.getLevel() == 1) {
			//如果是一级分类，父级类别id设为-1
			entity.setFirstLevelId(-1L);
		}
		Date now = new Date();
		entity.setGmtCreated(now);
		entity.setGmtModified(now);
		CategoryDO po = this.entity2do(entity);
		categoryDAO.insertSelective(po);
		return ResultUtils.setOk();
	}

	private CategoryDO entity2do(CategoryEntity entity) {
		CategoryDO po = new CategoryDO();
		BeanUtils.copyProperties(entity, po);
		return po;
	}

	@Override
	public ApiResult listFirstLevel() {
		CategoryDOExample example = new CategoryDOExample();
		example.setOrderByClause("gmt_created");
		example.createCriteria().andLevelEqualTo(1);
		List<CategoryDO> poList = categoryDAO.selectByExample(example);
		List<CategoryEntity> entityList = new ArrayList<>();
		for (CategoryDO po : poList) {
			entityList.add(this.do2entity(po));
		}
		return ResultUtils.setOk(entityList);
	}

	private CategoryEntity do2entity(CategoryDO po) {
		CategoryEntity entity = new CategoryEntity();
		BeanUtils.copyProperties(po, entity);
		return entity;
	}

	@Override
	public ApiResult listByParentId(Long parentId) {
		CategoryDOExample example = new CategoryDOExample();
		example.setOrderByClause("gmt_created");
		example.createCriteria().andParentIdEqualTo(parentId);
		List<CategoryDO> poList = categoryDAO.selectByExample(example);
		List<CategoryEntity> entityList = new ArrayList<>();
		for (CategoryDO po : poList) {
			entityList.add(this.do2entity(po));
		}
		return ResultUtils.setOk(entityList);
	}

	@Override
	public ApiResult delete(Long id) {
		return ResultUtils.setOk(categoryDAO.deleteByPrimaryKey(id));
	}

	@Override
	public ApiResult listSecondLevel() {
		CategoryDOExample example = new CategoryDOExample();
		example.setOrderByClause("gmt_created");
		example.createCriteria().andLevelEqualTo(2);
		List<CategoryDO> poList = categoryDAO.selectByExample(example);
		List<CategoryEntity> entityList = new ArrayList<>();
		for (CategoryDO po : poList) {
			entityList.add(this.do2entity(po));
		}
		return ResultUtils.setOk(entityList);
	}

	@Override
	public ApiResult listAll(PageVO page) {
		if (page == null) {
			page = new PageVO();
		}
		CategoryDOExample example = new CategoryDOExample();
		example.setOrderByClause("gmt_created");
		List<CategoryDO> poList = categoryDAO.selectByExample(example);
		List<CategoryEntity> entityList = new ArrayList<>();
		for (CategoryDO po : poList) {
			entityList.add(this.do2entity(po));
		}
		return ResultUtils.setOk(entityList);
	}

	@Override
	public CategoryEntity selectById(Long parentId) {
		CategoryDO po = categoryDAO.selectByPrimaryKey(parentId);
		return this.do2entity(po);
	}

}
