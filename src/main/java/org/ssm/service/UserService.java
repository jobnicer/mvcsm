package org.ssm.service;

import java.util.List;
import java.util.Map;

import org.ssm.model.Menu;
import org.ssm.model.User;
import org.ssm.util.PageModel;

public interface UserService {
	
	public List<Menu> loadMenu() throws Exception;
	
	public PageModel<User> initUserList(PageModel<User> pageModel) throws Exception;
	
	public PageModel<User> initEditUser(PageModel<User> pageModel) throws Exception;
	
	public PageModel<User> editUser(PageModel<User> pageModel) throws Exception;
	
	public PageModel<User> deleteUser(PageModel<User> pageModel) throws Exception;
	
	public PageModel<User> initChangePass(PageModel<User> pageModel, Map<String, Object> session) throws Exception;
	
	public PageModel<User> changePass(PageModel<User> pageModel) throws Exception;
	
	public PageModel<User> resetPass(PageModel<User> pageModel) throws Exception;
	
	public PageModel<User> queryUserByNameAndPass(PageModel<User> pageModel) throws Exception;
}
