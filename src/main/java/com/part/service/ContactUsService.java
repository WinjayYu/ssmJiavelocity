package com.part.service;

import com.part.entity.ApiResult;
import com.part.entity.ContactUsEntity;
import com.part.vo.PageVO;

public interface ContactUsService {

	public ApiResult add(ContactUsEntity entity);

	public ApiResult listAll(PageVO page);

	public ApiResult deleteById(Long id);
	
}
