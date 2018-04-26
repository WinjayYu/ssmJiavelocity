package com.part.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.part.Enum.UserTypeEnum;
import com.part.entity.ApiResult;
import com.part.entity.CategoryEntity;
import com.part.entity.ContactUsEntity;
import com.part.entity.JobEntity;
import com.part.entity.ResumeEntity;
import com.part.entity.UserEntity;
import com.part.service.CategoryService;
import com.part.service.ContactUsService;
import com.part.service.JobService;
import com.part.service.PageViewService;
import com.part.service.ResumeService;
import com.part.vo.CategoryConditionVO;
import com.part.vo.PageVO;

@Controller
@RequestMapping("/part")
public class PartTimeController {
	
	@Resource
	private JobService jobService;
	
	@Resource
	private PageViewService viewService;
	
	@Resource
	private ResumeService resumeService;
	
	@Resource
	private CategoryService categoryService;
	
	@Resource
	private ContactUsService contactService;

	@SuppressWarnings("unchecked")
	@RequestMapping("/index")
	public ModelAndView index(){
		ModelAndView modelAndView = new ModelAndView();
		//设置目标页面地址
		modelAndView.setViewName("/part/index");
		//职位列表
		PageVO page = (PageVO) jobService.listJob(null).getData();
		List<JobEntity> jobs = (List<JobEntity>)page.getData();
		modelAndView.addObject("jobs", jobs);
		
		//类别列表
		List<CategoryConditionVO> categorys = new ArrayList<>();
		List<CategoryEntity> firstList = (List<CategoryEntity>) categoryService.listFirstLevel().getData();
		if (firstList != null && !firstList.isEmpty()) {
			for (CategoryEntity en : firstList) {
				CategoryConditionVO vo = new CategoryConditionVO();
				BeanUtils.copyProperties(en, vo);
				List<CategoryEntity> childList = (List<CategoryEntity>) categoryService.listByParentId(en.getId()).getData();
				vo.setChilds(childList);
				categorys.add(vo);
			}
		}
		
		//最新职位
		List<JobEntity> newJobs = (List<JobEntity>) jobService.getNewJobs().getData();
		modelAndView.addObject("newJobs", newJobs);
		modelAndView.addObject("categorys", categorys);
		modelAndView.addObject("firstCategory", firstList);
		return modelAndView;
	}
	
	@RequestMapping("/job-detail")
	public ModelAndView jobDetail(@RequestParam("id") Long jobId){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/part/job/detail");
		//获取职位详情
		JobEntity entity = (JobEntity) jobService.getJobDetail(jobId).getData();
		modelAndView.addObject("job", entity);
		
		//获取访问量
		long viewCount = (long) viewService.searchCount(jobId).getData();
		modelAndView.addObject("viewCount", viewCount + 1);
		
		//获取简历投递数量
		long resumeCount = (long) resumeService.countForJob(jobId).getData();
		modelAndView.addObject("resumeCount", resumeCount);
		
		//相似职位
		
		return modelAndView;
	}
	
	@RequestMapping("/more-job")
	public ModelAndView moreJob(@RequestParam(value="categoryId", required = false) Long categoryId){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/part/job/list");
		modelAndView.addObject("categoryId", categoryId);
		return modelAndView;
	}
	
	@RequestMapping(value= "/list-job", method={RequestMethod.POST})
	@ResponseBody
	public ApiResult listJob(PageVO pager, JobEntity entity){
		return jobService.listJobByEntity(entity, pager);
	}
	
	@RequestMapping(value= "/addViewCount", method={RequestMethod.POST})
	@ResponseBody
	public ApiResult addCount(Long jobId){
		return viewService.addCount(jobId);
	}
	
	@RequestMapping(value= "/apply-job", method={RequestMethod.POST})
	@ResponseBody
	public ApiResult apply(ResumeEntity entity){
		return resumeService.resumeJob(entity);
	}
	
	@RequestMapping("/contact-us")
	public ModelAndView contact(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/part/contact");
		
		return modelAndView;
	}
	
	
	@RequestMapping("/contact")
	@ResponseBody
	public ApiResult contactUs(ContactUsEntity entity, HttpSession session){
		
		if (session.getAttribute("user") == null) {
			entity.setUserId(-1L);
		}
		
		return contactService.add(entity);
	}
	
	/**
     * 上传图片 
     * 
     */
    @RequestMapping(value = "/uploadpic", method = RequestMethod.POST)
    @ResponseBody
    public String uploadPic(@RequestParam("file") MultipartFile file, HttpServletRequest req)
            throws IOException {
        InputStream inputStream = file.getInputStream();
        String originalFilename = file.getOriginalFilename(); 
        System.err.println(originalFilename);
        return originalFilename;
    }
	
    @SuppressWarnings("unchecked")
	@RequestMapping("/myInfo")
    public ModelAndView myInfo(HttpSession session){
    	ModelAndView modelAndView = new ModelAndView();
    	UserEntity user = (UserEntity) session.getAttribute("user");
    	if (user == null) {
    		modelAndView.setViewName("/part/error");
    	} else {
    		//发布的职位
    		JobEntity entity = new JobEntity();
    		entity.setUserId(user.getId());
    		PageVO pager = new PageVO();
    		pager.setPageSize(100);
    		PageVO page = (PageVO) jobService.listJobByEntity(entity, pager).getData();
    		List<JobEntity> jobs = (List<JobEntity>) page.getData();
    		modelAndView.addObject("jobs", jobs);
    		modelAndView.addObject("jobsCount", jobs.size());
    		
    		//申请的职位
    		List<JobEntity> applyJobs = new ArrayList<>();
    		if (user.getType() == UserTypeEnum.USER.type) {
    			ApiResult ret = resumeService.listForUser(user.getId());
    			List<ResumeEntity> resumes = (List<ResumeEntity>) ret.getData();
    			if (resumes != null && !resumes.isEmpty()) {
    				for (ResumeEntity en : resumes) {
    					JobEntity job = (JobEntity) jobService.getJobDetail(en.getJobId()).getData();
    					applyJobs.add(job);
        			}
    			}
    			
    		}
    		modelAndView.addObject("applyJobs", applyJobs);
    		modelAndView.addObject("applyJobsCount", applyJobs.size());
    		
    		//应聘的人
    		
    		modelAndView.setViewName("/part/user/my-info");
    	}
    	
    	return modelAndView;
    }
    
    
}
