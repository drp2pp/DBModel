package com.multicampus.minishop.services.user;

import java.util.List;

import com.multicampus.minishop.common.Search;
import com.multicampus.minishop.services.domain.User;

public interface UserDao {
	
	public int insertUser(User vo) throws Exception;
	
	public User findUser(String userId) throws Exception;
	
	public List<Object> getUserList(Search search) throws Exception;
	
	public int updateUser(User vo) throws Exception;
	
	public int getTotalCount(Search search) throws Exception;
}
