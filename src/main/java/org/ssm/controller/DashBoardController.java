package org.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashBoard")
public class DashBoardController extends BaseController {
	
	/**
	* @MethodName ：dashBoard
	* @Description ：进入动态看板页面
	* @return String
	*/
	@RequestMapping(value="/dashBoard")
	public String dashBoard(){
		
		return "main/dashBoard";
	}
}
