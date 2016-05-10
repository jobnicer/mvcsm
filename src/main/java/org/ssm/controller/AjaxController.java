package org.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.ssm.model.User;
import org.ssm.service.UserService;
import org.ssm.util.DTO;
import org.ssm.util.PageModel;

import com.alibaba.fastjson.JSON;


@Controller
@RequestMapping("/ajax")
public class AjaxController extends BaseController {
	
//	@Autowired
//	private UserService userService;
//	PageModel pageModel = new PageModel();
//
//	@RequestMapping(value="/login", produces="application/json;charset=UTF-8")
//	@ResponseBody
//	public ModelAndView login() {
//		
//		ModelAndView modelAndView = new ModelAndView();
//		DTO dto = this.getDTO();
////		pageModel.setCondition(dto);
//		User user = null;
//		try {
//			user = userService.getUserByNameAndPass(dto);
//			if (user != null) {
////				modelAndView.setViewName("/login");
//				modelAndView.addObject("user", user);
//				modelAndView.addObject("msg","用户不为空");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return modelAndView;
//	}
//	
//	@RequestMapping(value="/success", method={RequestMethod.GET,RequestMethod.POST})
//	public String success() {
//		return "/success";
//	}
//	
//	@RequestMapping(value="/login2", produces="application/json;charset=UTF-8")
//	@ResponseBody
//	public ModelMap login2() {
//		ModelMap modelMap = new ModelMap();
//		DTO dto = this.getDTO();
//		User user = null;
//		try {
//			user = userService.getUserByNameAndPass(dto);
//			if (user != null) {
//				modelMap.put("user", user);
//				modelMap.put("msg","用户不为空");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return modelMap;
//	}
}
