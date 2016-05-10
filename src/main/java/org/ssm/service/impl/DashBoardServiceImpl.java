package org.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssm.dao.DashBoardMapper;
import org.ssm.model.DashBoardDataOne;
import org.ssm.service.DashBoardService;

@Service("dashBoardService")
public class DashBoardServiceImpl implements DashBoardService {
	
	@Autowired
	private DashBoardMapper dashBoardMapper;

	public List<DashBoardDataOne> createDataOne() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DashBoardDataOne> getDataOne() {
		
		return dashBoardMapper.selectInAndOutSum();
	}

}
