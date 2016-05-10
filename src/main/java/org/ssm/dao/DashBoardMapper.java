package org.ssm.dao;

import java.util.List;

import org.ssm.model.DashBoardDataOne;

public interface DashBoardMapper {
	
    List<DashBoardDataOne> selectInAndOutSum();
}