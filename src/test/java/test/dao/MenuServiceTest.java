package test.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.ssm.dao.MenuMapper;
import org.ssm.model.Menu;
import org.ssm.service.MenuService;

import com.alibaba.fastjson.JSON;
//import com.github.pagehelper.Page;
//import com.github.pagehelper.PageHelper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-service.xml", "classpath:spring-mybatis.xml" })
@Transactional
public class MenuServiceTest {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MenuMapper menuMapper;
	@Autowired
	private MenuService menuService;
	
	@Test
	public void test1() throws Exception {
		
	}

	@Test
	public void test2() throws Exception {
		
		List<Menu> allParentMenuList = menuMapper.selectAllParentMenu();
		logger.info(JSON.toJSONString(allParentMenuList));
	}

	@Test
	public void test3() throws Exception {
		
		Menu menu = menuMapper.selectMenuByPrimaryKey(10);
		logger.info(JSON.toJSONString(menu));
	}
	
	@Test
	public void test4() throws Exception {
		
		List<Menu> allMenuList = menuMapper.selectAllParentMenuWithSub();
		logger.info(JSON.toJSONString(allMenuList));
	}
	
	@Test
	public void test5() throws Exception {
	}

}
