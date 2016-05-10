package test.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.ssm.dao.UserMapper;
import org.ssm.model.User;

import com.alibaba.fastjson.JSON;
//import com.github.pagehelper.Page;
//import com.github.pagehelper.PageHelper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-service.xml", "classpath:spring-mybatis.xml" })
@Transactional
public class UserServiceTest {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void test1() throws Exception {
		
		User user = userMapper.selectUserAndRoleByPrimaryKey(1);
		logger.info(JSON.toJSONString(user));
	}

	@Test
	public void test2() throws Exception {
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("password", "admin");
		param.put("username", "123");
		User user = userMapper.selectUserByNameAndPass(param);
		logger.info(JSON.toJSONString(user));
	}

	@Test
	public void test3() throws Exception {
		
		Date date = new Date();
		logger.info(JSON.toJSONStringWithDateFormat(date, "yyyy-MM-dd HH:mm:ss"));
	}
	
	@Test
	public void test4() throws Exception {
	}
	
	@Test
	public void test5() throws Exception {
	}

}
