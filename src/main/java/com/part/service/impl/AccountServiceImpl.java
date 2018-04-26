package com.part.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.part.Enum.ResultCode;
import com.part.dao.UserDAO;
import com.part.dataobject.UserDO;
import com.part.dataobject.UserDOExample;
import com.part.entity.ApiResult;
import com.part.entity.UserEntity;
import com.part.service.AccountService;
import com.part.utils.ResultUtils;
import com.part.vo.PageVO;
@Service
public class AccountServiceImpl implements AccountService {

	@Resource
	private UserDAO userDAO;
	
	@Override
	public ApiResult regist(UserEntity user) {
		if (user == null) {;
			return ResultUtils.setError(ResultCode.PARAM_NULL,"user");
		}
		if (StringUtils.isBlank(user.getUserName())) {
			return ResultUtils.setError(ResultCode.PARAM_NULL,"用户名");
		}
		if (user.getNickName() == null) {
			user.setNickName(user.getUserName());
		}
		if (StringUtils.isBlank(user.getPassword())) {
			return ResultUtils.setError(ResultCode.PARAM_NULL,"密码");
		}
		if (user.getType() == null) {
			return ResultUtils.setError(ResultCode.PARAM_NULL,"用户类型");
		}
		UserDOExample example = new UserDOExample();
		example.createCriteria().andUserNameEqualTo(user.getUserName());
		List<UserDO> poList = userDAO.selectByExample(example);
		if (poList != null && !poList.isEmpty()) {
			return ResultUtils.setError(ResultCode.USERNAME_EXIST);
		}
		Date now = new Date();
		user.setGmtCreated(now);
		user.setGmtModified(now);
		int line = userDAO.insertSelective(this.entity2do(user));
		if (line < 1) {
			return ResultUtils.setError(ResultCode.REGIST_FAILED);
		}
		return ResultUtils.setOk();
	}

	@Override
	public ApiResult login(UserEntity user) {
		if (user == null) {
			return ResultUtils.setError(ResultCode.PARAM_NULL,"user");
		}
		if (StringUtils.isBlank(user.getUserName())) {
			return ResultUtils.setError(ResultCode.PARAM_NULL,"用户名");
		}
		if (StringUtils.isBlank(user.getPassword())) {
			return ResultUtils.setError(ResultCode.PARAM_NULL,"密码");
		}
		UserDOExample example = new UserDOExample();
		example.createCriteria().andUserNameEqualTo(user.getUserName()).andPasswordEqualTo(user.getPassword());
		List<UserDO> poList = userDAO.selectByExample(example);
		if (poList == null || poList.isEmpty()) {
			return ResultUtils.setError(ResultCode.LOGIN_FAILED);
		}
		return ResultUtils.setOk(this.do2entity(poList.get(0)));
	}

	@Override
	public ApiResult updateInfo(UserEntity user) {
		if (user == null) {
			return ResultUtils.setError(ResultCode.PARAM_NULL,"user");
		}
		if (user.getId() == null) {
			return ResultUtils.setError(ResultCode.PARAM_NULL,"userId");
		}
		int line = userDAO.updateByPrimaryKeySelective(this.entity2do(user));
		if (line < 1) {
			return ResultUtils.setError(ResultCode.UPDATE_FAILED);
		}
		UserDO po = userDAO.selectByPrimaryKey(user.getId());
		return ResultUtils.setOk(this.do2entity(po));
	}

	@Override
	public ApiResult listUserByType(Integer type, PageVO pager) {
		//如果没有设置分页，则设置默认分页
		if (pager == null) {
			pager = new PageVO();
		}
		UserDOExample example = new UserDOExample();
		example.setPage(pager);
		//按时间倒序
		example.setOrderByClause("gmt_created desc");
		example.createCriteria().andTypeEqualTo(type);
		List<UserDO> poList = userDAO.selectByExample(example);
		List<UserEntity> entityList = new ArrayList<>();
		for (UserDO po : poList) {
			entityList.add(this.do2entity(po));
		}
		return ResultUtils.setOk(entityList);
	}

	@Override
	public ApiResult listAllUser(PageVO pager) {
		if (pager == null) {
			pager = new PageVO();
		}
		UserDOExample example = new UserDOExample();
		example.setPage(pager);
		//按时间倒序
		example.setOrderByClause("gmt_created");
		List<UserDO> poList = userDAO.selectByExample(example);
		List<UserEntity> entityList = new ArrayList<>();
		for (UserDO po : poList) {
			entityList.add(this.do2entity(po));
		}
		return ResultUtils.setOk(entityList);
	}

	private UserDO entity2do(UserEntity user) {
		UserDO po = new UserDO();
		BeanUtils.copyProperties(user, po);
		return po;
	}

	private UserEntity do2entity(UserDO po) {
		UserEntity entity = new UserEntity();
		BeanUtils.copyProperties(po, entity);
		return entity;
	}

	@Override
	public ApiResult deleteById(Long id) {
		int line = userDAO.deleteByPrimaryKey(id);
		if (line < 1) {
			return ResultUtils.setError(ResultCode.UNKNOWN_ERROR);
		}
		return ResultUtils.setOk();
	}
}
