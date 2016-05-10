package org.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.ssm.model.User;
import org.ssm.service.UserService;

import com.alibaba.fastjson.JSON;


@Controller
@RequestMapping("/user")
@ResponseBody
public class UserController {
	
//	@Autowired
//	private UserService userService;
//
//	@RequestMapping(value="/showUser2", method={RequestMethod.GET,RequestMethod.POST}) 
//	public ModelAndView showUser2() {
//		
//		ModelAndView modelAndView = new ModelAndView();
//		User user = null;
//		try {
//			user = userService.getUserById(2);
//		} catch (NumberFormatException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		modelAndView.addObject("user", user);
//		modelAndView.setViewName("/showUser2");
//		return modelAndView;
//	}
//
//	@RequestMapping(value="/showUser", method=RequestMethod.GET)
//	public ModelAndView showUser(HttpServletRequest request) {
//		
//		ModelAndView modelAndView = new ModelAndView();
//		List<User> list = null;
//		try {
//			list = userService.getAllUser();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		String json = JSON.toJSONString(list);
//		modelAndView.addObject("json", json);
//		modelAndView.addObject("list", list);
//		modelAndView.setViewName("/showUser");
//		return modelAndView;
//	}

	
}
