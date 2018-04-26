package com.part.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.part.Enum.ResultCode;
import com.part.Enum.UserTypeEnum;
import com.part.entity.ApiResult;
import com.part.entity.UserEntity;
import com.part.service.AccountService;
import com.part.utils.Base64;
import com.part.utils.ResultUtils;
import com.part.web.core.bind.annotation.FormModel;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Resource
	private AccountService accountService;
	
	/**
	 * 登录
	 * @param user
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/login", method={RequestMethod.POST})
	@ResponseBody
	public ApiResult login(@FormModel("user") UserEntity user, HttpSession session) {
		ApiResult ret = accountService.login(user);
		if (user.getType() == UserTypeEnum.ADMIN.type) {
			return ResultUtils.setError(ResultCode.LOGIN_FAILED,"管理员不允许在此页面登录");
		}
		if (ret.isSuccess()) {
			//如果登录成功，将用户信息放入session
			session.setAttribute("user", (UserEntity) ret.getData());
		}
		return ret;
	}
	
	/**
	 * 注销
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/log-off", method={RequestMethod.POST})
	@ResponseBody
	public ApiResult logOff(HttpSession session){
		//删除session信息
		session.removeAttribute("user");
		return ResultUtils.setOk();
	}
	
	@RequestMapping(value="/regist")
	public ModelAndView regist(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/part/regist");
		return modelAndView;
	}
	
	/**
	 * 注册
	 * @param entity
	 * @return
	 */
	@RequestMapping(value="/do-regist", method={RequestMethod.POST})
	@ResponseBody
	public ApiResult doRegist(@FormModel("entity") UserEntity entity){
		return accountService.regist(entity);
	}
	
	@RequestMapping("/add-user-icon")
	public ModelAndView addIcon(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/part/user/modify-icon");
		return modelAndView;
	}
	
	/**
	 * 修改用户头像
	 * @param entity
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/modify-icon", method={RequestMethod.POST})
	@ResponseBody
	public ApiResult modifyIcon(UserEntity entity, HttpServletRequest request, HttpSession session){
		if (entity == null || entity.getIcon() == null || entity.getId() == null) {
			return ResultUtils.setError(ResultCode.PARAM_NULL);
		}
		String imgFilePath = "",imgPath="";
		String[] imageBase64Array = entity.getIcon().split(",");
        String imageBase64 = imageBase64Array[1];
        byte[] imageByte = Base64.decode(imageBase64);
		
        String basePath = request.getSession().getServletContext().getRealPath("/resources/imgs/userIcon");
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String fileName = uuid + ".jpg";
        
        try{
        	File file = new File(basePath);
        	if (!file.exists()) {
        		file.mkdirs();// 创建父目录地址
        	}
        	// 生成jpeg图片
        	imgFilePath = basePath +"\\" + fileName;
        	imgPath = "http://localhost:8081/part-web/resources/imgs/userIcon/" + fileName;
        	OutputStream out=new FileOutputStream(imgFilePath);

        	out.write(imageByte);
        	out.flush();
        	out.close();
        }catch (Exception e){
        	return ResultUtils.setError(ResultCode.UPDATE_FAILED);
        }
        entity.setIcon(imgPath);
        accountService.updateInfo(entity);
        UserEntity user = (UserEntity) session.getAttribute("user");
        user.setIcon(imgPath);
        session.setAttribute("user", user);
        return ResultUtils.setOk(imgPath);
	}
	
	@RequestMapping("/modify-info-view")
	public ModelAndView modifyInfoView(HttpSession session){
		UserEntity user = (UserEntity) session.getAttribute("user");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/part/user/modify-info");
		modelAndView.addObject("entity", user);
		return modelAndView;
	}
	
	@RequestMapping(value="/do-modify", method={RequestMethod.POST})
	@ResponseBody
	public ApiResult doModify(@FormModel("entity") UserEntity entity, HttpSession session){
		ApiResult ret = accountService.updateInfo(entity);
		if (!ret.isSuccess()) {
			return ret;
		}
		UserEntity user = (UserEntity) ret.getData();
		session.setAttribute("user", user);
		return ResultUtils.setOk();
	}
	
	//管理员登录
	@RequestMapping("/ad-login")
	@ResponseBody
	public ApiResult adLogin(UserEntity user, HttpSession session) {
		ApiResult ret = accountService.login(user);
		if (ret.isSuccess()) {
			//如果登录成功，将用户信息放入session
			session.setAttribute("user", (UserEntity) ret.getData());
		}
		return ret;
	}
	
	/**
	 * 管理员退出
	 * @param session
	 * @return
	 */
	@RequestMapping("/ad-logout")
	@ResponseBody
	public ApiResult adLogout(HttpSession session) {
		session.removeAttribute("user");
		return ResultUtils.setOk();
	}
	
}
