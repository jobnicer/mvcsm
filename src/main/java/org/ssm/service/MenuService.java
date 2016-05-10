package org.ssm.service;

import java.util.List;

import org.ssm.model.Menu;

public interface MenuService {

	public List<Menu> queryAllParentMenuWithSubList() throws Exception;
	
	public List<Menu> queryAllParentMenuList() throws Exception;
	
	public List<Menu> querySubMenuListByParent(Integer parentId) throws Exception;
	
}
