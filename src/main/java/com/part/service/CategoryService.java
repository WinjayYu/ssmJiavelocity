package com.part.service;

import com.part.entity.ApiResult;
import com.part.entity.CategoryEntity;
import com.part.vo.PageVO;

public interface CategoryService {

	/**
	 * 创建分类
	 * @param entity
	 * @return
	 */
	public ApiResult createCategory(CategoryEntity entity);
	
	/**
	 * 获取一级分类
	 * @return
	 */
	public ApiResult listFirstLevel();
	
	/**
	 * 根据parentId查找子级分类
	 * @param parentId
	 * @return
	 */
	public ApiResult listByParentId(Long parentId);
	
	/**
	 * 根据 id删除分类
	 * @param id
	 * @return
	 */
	public ApiResult delete(Long id);
	
	/**
	 * 获取二级分类
	 * @return
	 */
	public ApiResult listSecondLevel();

	public ApiResult listAll(PageVO page);

	public CategoryEntity selectById(Long parentId);
}
