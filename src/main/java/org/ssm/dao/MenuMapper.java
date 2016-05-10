package org.ssm.dao;

import java.util.List;
import org.ssm.model.Menu;

public interface MenuMapper {
	
    int deleteMenuByPrimaryKey(Integer menuId);

    int insertMenu(Menu record);

    Menu selectMenuByPrimaryKey(Integer menuId);

    List<Menu> selectAllParentMenu();
    
    List<Menu> selectSubMenuByParent(Integer parentId);

    int updateMenuByPrimaryKey(Menu record);
    
    List<Menu> selectAllParentMenuWithSub();
    
}