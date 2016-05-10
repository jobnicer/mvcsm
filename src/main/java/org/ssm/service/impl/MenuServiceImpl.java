package org.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssm.dao.MenuMapper;
import org.ssm.model.Menu;
import org.ssm.service.MenuService;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper menuMapper;
	
	//方式1,方式2直接sql语句查询出来，见MenuMapper里的selectAllParentMenuWithSub()
	public List<Menu> queryAllParentMenuWithSubList() throws Exception {
		
		List<Menu> allParentMenuList = this.queryAllParentMenuList();
		for(Menu menu : allParentMenuList) {
			List<Menu> subMenuList = this.querySubMenuListByParent(menu.getParentId());
			menu.setSubMenuList(subMenuList);
		}
		return allParentMenuList;
	}
	
	public List<Menu> queryAllParentMenuList() throws Exception {
		
		return menuMapper.selectAllParentMenu();
	}
	
	public List<Menu> querySubMenuListByParent(Integer parentId) throws Exception {
		
		return menuMapper.selectSubMenuByParent(parentId);
	}

}
