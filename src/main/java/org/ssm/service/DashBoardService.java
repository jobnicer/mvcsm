package org.ssm.service;

import java.util.List;

import org.ssm.model.DashBoardDataOne;

public interface DashBoardService {

	public List<DashBoardDataOne> createDataOne();
	
	public List<DashBoardDataOne> getDataOne();
}
