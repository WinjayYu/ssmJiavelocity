package com.part.vo;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.part.entity.CategoryEntity;

public class CategoryConditionVO extends CategoryEntity{

	private static final long serialVersionUID = -9211858853633138593L;

	private List<CategoryEntity> childs;

	public List<CategoryEntity> getChilds() {
		return childs;
	}

	public void setChilds(List<CategoryEntity> childs) {
		this.childs = childs;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
	
}
