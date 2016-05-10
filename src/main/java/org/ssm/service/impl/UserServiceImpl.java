package org.ssm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.PrincipalMap;
import org.apache.shiro.subject.SimplePrincipalMap;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssm.dao.MenuMapper;
import org.ssm.dao.UserMapper;
import org.ssm.model.Menu;
import org.ssm.model.Role;
import org.ssm.model.User;
import org.ssm.service.UserService;
import org.ssm.util.Const;
import org.ssm.util.DTO;
import org.ssm.util.PageModel;
import org.ssm.util.RightsHelper;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private MenuMapper menuMapper;

	@SuppressWarnings("unchecked")
	public List<Menu> loadMenu() throws Exception {
		
		//shiro管理的session
		Subject currentUser = SecurityUtils.getSubject();  
		Session session = currentUser.getSession();
		//成功登录系统后获取session中的用户对象，未带角色
		User user = (User)session.getAttribute(Const.SESSION_USER);
		List<Menu> allmenuList = new ArrayList<Menu>();
		
		if(user != null) {
			//避免每次拦截用户操作时查询数据库，先从session取用户带角色对象
			User userRole = (User)session.getAttribute(Const.SESSION_USER_ROLE);
			if(userRole == null){
				user = userMapper.selectUserAndRoleByPrimaryKey(user.getUserId());
				session.setAttribute(Const.SESSION_USER_ROLE, user);
			}else {
				user = userRole;
			}
				
			Role role = user.getRole();
			String roleRights = role!=null ? role.getRights() : "";
			//避免每次拦截用户操作时查询数据库，将用户所属角色权都存入session
			session.setAttribute(Const.SESSION_ROLE_RIGHTS, roleRights); 
			
			if(session.getAttribute(Const.SESSION_ALL_MENU) == null) {
				allmenuList = menuMapper.selectAllParentMenuWithSub();
				if(StringUtils.isNotEmpty(roleRights)){
					for(Menu menu : allmenuList){
						menu.setHasMenu(RightsHelper.testRights(roleRights, menu.getMenuId()));
						if(menu.getHasMenu()){
							List<Menu> subMenuList = menu.getSubMenuList();
							for(Menu sub : subMenuList){
								sub.setHasMenu(RightsHelper.testRights(roleRights, sub.getMenuId()));
							}
						}
					}
				}
				//所有菜单权限放入session中
				session.setAttribute(Const.SESSION_ALL_MENU, allmenuList);			
			}else {
				allmenuList = (List<Menu>) session.getAttribute(Const.SESSION_ALL_MENU);
			}
		}
		return allmenuList;
	}

	public PageModel<User> initUserList(PageModel<User> pageModel) throws Exception {
		
		return null;
	}

	public PageModel<User> initEditUser(PageModel<User> pageModel) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public PageModel<User> editUser(PageModel<User> pageModel) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public PageModel<User> deleteUser(PageModel<User> pageModel) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public PageModel<User> initChangePass(PageModel<User> pageModel, Map<String, Object> session) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public PageModel<User> changePass(PageModel<User> pageModel) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public PageModel<User> resetPass(PageModel<User> pageModel) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public PageModel<User> queryUserByNameAndPass(PageModel<User> pageModel) throws Exception {
		
		DTO dto = pageModel.getCondition();
		String username = dto.getString("username");
		String password = dto.getString("password");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("password", password);
		param.put("username", username);
		User user = userMapper.selectUserByNameAndPass(param);
		
		if(user != null) {
			//shiro管理的session
			Subject currentUser = SecurityUtils.getSubject();  
			Session session = currentUser.getSession();
			pageModel.setResult(user);
			pageModel.setSuccess(true);
			pageModel.setMessage("登录成功");
			session.setAttribute(Const.SESSION_USER, user);
			//将用户名和密码加入shiro身份验证
			Subject subject = SecurityUtils.getSubject(); 
		    UsernamePasswordToken token = new UsernamePasswordToken(username, password); 
		    try { 
		        subject.login(token); 
		    } catch (AuthenticationException e) { 
		    	pageModel.setMessage("身份验证失败");
		    }
		}else {
			pageModel.setSuccess(false);
			pageModel.setMessage("用户名或者密码错误");
		}
		return pageModel;
	}
	
}
