package test.dao;



import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.ssm.model.DashBoardDataOne;
import org.ssm.service.DashBoardService;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-service.xml", "classpath:spring-mybatis.xml" })
@Transactional
public class DashBoardServiceTest {
	
	@Autowired
	private DashBoardService dashBoardService;
	
	@Test
	public void test1() throws Exception {
		List<DashBoardDataOne> dataOne = dashBoardService.getDataOne();
		System.out.println(JSON.toJSONString(dataOne));
	}


}
