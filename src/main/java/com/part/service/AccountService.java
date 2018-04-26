package com.part.service;

import com.part.entity.ApiResult;
import com.part.entity.UserEntity;
import com.part.vo.PageVO;

public interface AccountService {

	/**
	 * 注册
	 * @param user
	 * @return
	 */
	public ApiResult regist(UserEntity user);
	
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	public ApiResult login(UserEntity user);
	
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	public ApiResult updateInfo(UserEntity user);
	
	/**
	 * 分页查看用户列表
	 * @param type
	 * @param pager
	 * @return
	 */
	public ApiResult listUserByType(Integer type, PageVO pager);
	
	/**
	 * 用户列表
	 * @return
	 */
	public ApiResult listAllUser(PageVO pager);

	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	public ApiResult deleteById(Long id);
	
}
