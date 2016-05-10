package org.ssm.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import org.ssm.util.DTO;
import org.ssm.util.PageModel;

@SuppressWarnings({"rawtypes"})
public class BaseController {
	
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 得到DTO
	 */
	public DTO getDTO(){
		return new DTO(this.getRequest());
	}
	
	/**
	 * 得到request对象
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		return request;
	}

	/**
	 * 得到分页列表的信息 
	 */
	public PageModel getPageInfo(){
		return new PageModel();
	}
	
}
