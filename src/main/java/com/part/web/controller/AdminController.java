package com.part.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.part.Enum.ResultCode;
import com.part.entity.ApiResult;
import com.part.entity.CategoryEntity;
import com.part.entity.ContactUsEntity;
import com.part.entity.JobEntity;
import com.part.entity.NewsEntity;
import com.part.entity.UserEntity;
import com.part.service.AccountService;
import com.part.service.CategoryService;
import com.part.service.ContactUsService;
import com.part.service.JobService;
import com.part.service.NewsService;
import com.part.utils.Base64;
import com.part.utils.ResultUtils;
import com.part.vo.LayUITablePageVO;
import com.part.vo.PageVO;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Resource
	private JobService jobService;
	
	@Resource
	private CategoryService categoryService;
	
	@Resource
	private NewsService newsService;
	
	@Resource
	private AccountService accountService;
	
	@Resource
	private ContactUsService contactService;
	
	@RequestMapping("/login")
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin/login");
		return modelAndView;
	}
	
	@RequestMapping("/index")
	public ModelAndView index(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin/index");
		return modelAndView;
	}
	
	@RequestMapping("/userInfo")
	public ModelAndView userInfo() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin/userInfo");
		return modelAndView;
	}
	
	@RequestMapping("/job-list")
	public ModelAndView jobList() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin/job-list");
		return modelAndView;
	}
	
	@RequestMapping("/publish-job")
	public ModelAndView publishView() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin/publish");
		List<CategoryEntity> cates = (List<CategoryEntity>) categoryService.listSecondLevel().getData();
		modelAndView.addObject("cates", cates);
		return modelAndView;
	}
	
	@RequestMapping("/my-publish")
	public ModelAndView myPublishView(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin/my-publish");
		return modelAndView;
	}
	
	@RequestMapping("/news-listView")
	public ModelAndView newsView(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin/news-list");
		return modelAndView;
	}
	
	@RequestMapping("/add-newsView")
	public ModelAndView addnewsView(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin/add-news");
		return modelAndView;
	}
	
	@RequestMapping("/user-listView")
	public ModelAndView userView(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin/user-list");
		return modelAndView;
	}
	
	@RequestMapping("/contact-view")
	public ModelAndView con(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin/contact-list");
		return modelAndView;
	}
	
	@RequestMapping("/category-view")
	public ModelAndView categoryView(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin/category");
		return modelAndView;
	}
	
	@RequestMapping("/add-categoryView")
	public ModelAndView addCategoryView(){
		ModelAndView modelAndView = new ModelAndView();
		
		List<CategoryEntity> categorys = (List<CategoryEntity>) categoryService.listFirstLevel().getData();
		modelAndView.addObject("categorys", categorys);
		modelAndView.setViewName("/admin/add-category");
		return modelAndView;
	}
	
	@RequestMapping("/add-first-categoryView")
	public ModelAndView addFirstCategoryView(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin/add-first-category");
		return modelAndView;
	}
	
	/**
	 * 职位列表
	 * @return
	 */
	@RequestMapping("/joblist")
	@ResponseBody
	public LayUITablePageVO list(PageVO page) {
		ApiResult ret = jobService.listJob(page);
		PageVO pager = (PageVO) ret.getData();
		List<JobEntity> jobs = (List<JobEntity>) pager.getData();
		LayUITablePageVO vo = new LayUITablePageVO();
		vo.setCode(ret.getCode());
		vo.setCount((long)jobs.size());
		vo.setMsg(ret.getError() == null?"":ret.getError());
		vo.setData(jobs);
		return vo;
	}
	
	/**
	 * 我发布的职位列表
	 * @return
	 */
	@RequestMapping("/my-joblist")
	@ResponseBody
	public LayUITablePageVO myJobList(PageVO page,HttpSession session) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		if (user == null) {
			return null;
		}
		JobEntity job = new JobEntity();
		job.setUserId(user.getId());
		ApiResult ret = jobService.listJobByEntity(job, page);
		PageVO pager = (PageVO) ret.getData();
		List<JobEntity> jobs = (List<JobEntity>) pager.getData();
		LayUITablePageVO vo = new LayUITablePageVO();
		vo.setCode(ret.getCode());
		vo.setCount((long)jobs.size());
		vo.setMsg(ret.getError() == null?"":ret.getError());
		vo.setData(jobs);
		return vo;
	}
	
	/**
	 * 删除职位
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteJob", method={RequestMethod.POST})
	@ResponseBody
	public ApiResult deleteJob(Long id){
		return jobService.deleteJob(id);
	}
	
	@RequestMapping(value = "/publish", method={RequestMethod.POST})
	@ResponseBody
	public ApiResult publish(@RequestParam("formData") String formData, HttpSession session){
		
		JobEntity job;
		try {
			job = JSONObject.parseObject(formData, JobEntity.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultUtils.setError(ResultCode.UNKNOWN_ERROR);
		}
		UserEntity user = (UserEntity) session.getAttribute("user");
		
		if (user == null) {
			return ResultUtils.setError(ResultCode.NOT_LOGIN);
		}
		job.setUserId(user.getId());
		return jobService.publish(job);
	}
	
	/**
	 * 发布新闻
	 * @param entity
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/add-news", method={RequestMethod.POST})
	@ResponseBody
	public ApiResult addNews(@RequestBody NewsEntity entity, HttpServletRequest request, HttpSession session){
		if (entity == null || entity.getPicUrl() == null) {
			return ResultUtils.setError(ResultCode.PARAM_NULL);
		}
		String imgFilePath = "",imgPath="";
		String[] imageBase64Array = entity.getPicUrl().split(",");
        String imageBase64 = imageBase64Array[1];
        byte[] imageByte = Base64.decode(imageBase64);
		
        String basePath = request.getSession().getServletContext().getRealPath("/resources/imgs/news");
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String fileName = uuid + ".jpg";
        
        try{
        	File file = new File(basePath);
        	if (!file.exists()) {
        		file.mkdirs();// 创建父目录地址
        	}
        	// 生成jpeg图片
        	imgFilePath = basePath +"\\" + fileName;
//        	imgPath = "http://localhost:8081/part-web/resources/imgs/news/" + fileName;
			imgPath = "http://localhost:8081/resources/imgs/news/" + fileName;
        	OutputStream out=new FileOutputStream(imgFilePath);

        	out.write(imageByte);
        	out.flush();
        	out.close();
        }catch (Exception e){
        	return ResultUtils.setError(ResultCode.UPDATE_FAILED);
        }
        entity.setPicUrl(imgPath);
        UserEntity user = (UserEntity) session.getAttribute("user");
        if (user == null) {
        	return ResultUtils.setError(ResultCode.NOT_LOGIN);
        }
        entity.setCreatedId(user.getId());
        
        newsService.createNews(entity);
        return ResultUtils.setOk(imgPath);
	}
	
	/**
	 * 新闻列表
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/newslist", method={RequestMethod.POST})
	@ResponseBody
	public LayUITablePageVO news(PageVO page){
		ApiResult ret = newsService.listByEntity(null, page);
		PageVO pager = (PageVO) ret.getData();
		List<NewsEntity> jobs = (List<NewsEntity>) pager.getData();
		LayUITablePageVO vo = new LayUITablePageVO();
		vo.setCode(ret.getCode());
		vo.setCount((long)jobs.size());
		vo.setMsg(ret.getError() == null?"":ret.getError());
		vo.setData(jobs);
		return vo;
	}
	
	@RequestMapping(value="/deleteNews", method={RequestMethod.POST})
	@ResponseBody
	public ApiResult deleteNews(Long id){
		List<Long> ids = new ArrayList<>();
		ids.add(id);
		return newsService.deleteByIds(ids);
	}
	
	/**
	 * 用户列表
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/user-list", method={RequestMethod.POST})
	@ResponseBody
	public LayUITablePageVO users(PageVO page){
		ApiResult ret = accountService.listAllUser(page);
		List<UserEntity> users = (List<UserEntity>) ret.getData();
		LayUITablePageVO vo = new LayUITablePageVO();
		vo.setCode(ret.getCode());
		vo.setCount((long)users.size());
		vo.setMsg(ret.getError() == null?"":ret.getError());
		vo.setData(users);
		return vo;
	}	
	
	@RequestMapping(value="/deleteUser", method={RequestMethod.POST})
	@ResponseBody
	public ApiResult deleteUser(Long id){
		return accountService.deleteById(id);
	}
	
	@RequestMapping(value="/contact-list", method={RequestMethod.POST})
	@ResponseBody
	public LayUITablePageVO contacts(PageVO page){
		ApiResult ret = contactService.listAll(page);
		List<ContactUsEntity> contacts = (List<ContactUsEntity>) ret.getData();
		LayUITablePageVO vo = new LayUITablePageVO();
		vo.setCode(ret.getCode());
		vo.setCount((long)contacts.size());
		vo.setMsg(ret.getError() == null?"":ret.getError());
		vo.setData(contacts);
		return vo;
	}
	
	@RequestMapping(value="/deleteContact", method={RequestMethod.POST})
	@ResponseBody
	public ApiResult deleteContact(Long id){
		return contactService.deleteById(id);
	}
	
	@RequestMapping(value="/category-list", method={RequestMethod.POST})
	@ResponseBody
	public LayUITablePageVO categorytList(PageVO page){
		ApiResult ret = categoryService.listAll(page);
		List<ContactUsEntity> contacts = (List<ContactUsEntity>) ret.getData();
		LayUITablePageVO vo = new LayUITablePageVO();
		vo.setCode(ret.getCode());
		vo.setCount((long)contacts.size());
		vo.setMsg(ret.getError() == null?"":ret.getError());
		vo.setData(contacts);
		return vo;
	}
	
	@RequestMapping(value="/deleteCategory", method={RequestMethod.POST})
	@ResponseBody
	public ApiResult deleteCategory(Long id){
		return categoryService.delete(id);
	}
	
	@RequestMapping(value="/add-category", method={RequestMethod.POST})
	@ResponseBody
	public ApiResult addCategory(@RequestBody CategoryEntity entity){
		if (entity.getParentId() != -1) {
			CategoryEntity cate = categoryService.selectById(entity.getParentId());
			entity.setFirstLevelId(cate.getId());
			entity.setParentName(cate.getName());
		}
		
		return categoryService.createCategory(entity);
	}
	
}
