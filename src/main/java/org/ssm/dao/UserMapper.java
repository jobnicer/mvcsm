package org.ssm.dao;

import java.util.List;
import java.util.Map;

import org.ssm.model.User;

public interface UserMapper {
	
    int deleteUserByPrimaryKey(Integer userId);

    int insertUser(User record);

    List<User> selectUserByExample(User example);

    User selectUserByPrimaryKey(Integer userId);
    
    User selectUserAndRoleByPrimaryKey(Integer userId);

    int updateUserByPrimaryKey(User record);
    
    User selectUserByNameAndPass(Map<String, Object> param);
}