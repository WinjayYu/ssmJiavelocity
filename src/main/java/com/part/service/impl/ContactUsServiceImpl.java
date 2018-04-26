package com.part.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.part.Enum.ResultCode;
import com.part.dao.ContactDAO;
import com.part.dataobject.ContactUsDO;
import com.part.dataobject.ContactUsDOExample;
import com.part.entity.ApiResult;
import com.part.entity.ContactUsEntity;
import com.part.service.ContactUsService;
import com.part.utils.ResultUtils;
import com.part.vo.PageVO;
@Service
public class ContactUsServiceImpl implements ContactUsService {

	@Resource
	private ContactDAO contactDAO;
	
	@Override
	public ApiResult add(ContactUsEntity entity) {
		return ResultUtils.setOk(contactDAO.insertSelective(this.entity2do(entity)));
	}

	private ContactUsDO entity2do(ContactUsEntity entity) {
		ContactUsDO po = new ContactUsDO();
		BeanUtils.copyProperties(entity, po);
		return po;
	}

	@Override
	public ApiResult listAll(PageVO page) {
		if (page == null) {
			page = new PageVO();
		}
		ContactUsDOExample example = new ContactUsDOExample();
		example.setPage(page);
		List<ContactUsDO> poList = contactDAO.selectByExample(example);
		List<ContactUsEntity> entityList = new ArrayList<>();
		for (ContactUsDO po : poList) {
			entityList.add(this.do2entity(po));
		}
		return ResultUtils.setOk(entityList);
	}

	private ContactUsEntity do2entity(ContactUsDO po) {
		ContactUsEntity entity = new ContactUsEntity();
		BeanUtils.copyProperties(po, entity);
		return entity;
	}

	@Override
	public ApiResult deleteById(Long id) {
		int line = contactDAO.deleteByPrimaryKey(id);
		if (line < 1) {
			return ResultUtils.setError(ResultCode.DATA_NOT_FOUND);
		}
		return ResultUtils.setOk();
	}


}
