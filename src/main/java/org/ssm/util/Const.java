package org.ssm.util;

import org.springframework.context.ApplicationContext;

public class Const {
	
	public static final String SESSION_USER = "SESSION_USER";                //用户不带角色
	public static final String SESSION_USER_ROLE = "SESSION_USER_ROLE";      //用户带角色
	public static final String SESSION_ROLE_RIGHTS = "SESSION_ROLE_RIGHTS";  //角色菜单权限
	public static final String SESSION_MENU = "SESSION_MENU";			     //角色拥有菜单
	public static final String SESSION_ALL_MENU = "SESSION_ALL_MENU";		 //全部菜单
	public static final String SESSION_QX = "SESSION_QX";
	public static final String TRUE = "T";
	public static final String FALSE = "F";
	public static final String SYSNAME = "航班信息统计系统";	                 //系统名称
	
	
	public static ApplicationContext WEB_APP_CONTEXT = null; //该值会在web容器启动时由WebAppContextListener初始化
	
}