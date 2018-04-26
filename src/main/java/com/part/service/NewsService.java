package com.part.service;

import java.util.List;

import com.part.entity.ApiResult;
import com.part.entity.NewsEntity;
import com.part.vo.PageVO;

public interface NewsService {

	public ApiResult createNews(NewsEntity entity);
	
	public ApiResult listByEntity(NewsEntity entity, PageVO pager);
	
	public ApiResult deleteByIds(List<Long> ids);
}
