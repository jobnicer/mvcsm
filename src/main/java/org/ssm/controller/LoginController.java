package org.ssm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.ssm.model.Menu;
import org.ssm.model.User;
import org.ssm.service.UserService;
import org.ssm.util.Const;
import org.ssm.util.PageModel;

@Controller
public class LoginController extends BaseController {

	@Autowired
	private UserService userService;
	private PageModel<User> pageModel = new PageModel<User>();
	
	@RequestMapping(value="/toLogin")
	public ModelAndView toLogin()throws Exception{
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("main/login");
		modelAndView.addObject("sysName", Const.SYSNAME);//获取系统名称
		return modelAndView;
	}

	@RequestMapping(value="/login", method={RequestMethod.GET,RequestMethod.POST}) 
	@ResponseBody
	public ModelMap login() {
		
		ModelMap modelMap = new ModelMap();
		pageModel.setCondition(getDTO());
		try {
			pageModel = userService.queryUserByNameAndPass(pageModel);
//			logger.info("测试日志");
		} catch (Exception e) {
			logger.error("{用户登录失败}", e);
		}
		modelMap.addAttribute("pageModel", pageModel);
		modelMap.addAttribute("sysName", Const.SYSNAME);
		return modelMap;
	}
	
	@RequestMapping(value="/index", method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView index() {
		
		List<Menu> allMenuList = new ArrayList<Menu>();
		try {
			allMenuList = userService.loadMenu();
		} catch (Exception e) {
			logger.error("{获取用户权限失败}", e);
		} 
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("main/index");
		modelAndView.addObject("allMenuList",allMenuList);
		modelAndView.addObject("sysName", Const.SYSNAME);//获取系统名称
		return modelAndView;
	}
	
	/**
	* @MethodName ：tab
	* @Description ：进入tab标签
	* @return String
	*/
	@RequestMapping(value="/tab")
	public String tab(){
		return "main/tab";
	}
	
}
