package com.multicampus.minishop.services.user;

import java.util.Map;

import com.multicampus.minishop.common.Search;
import com.multicampus.minishop.services.domain.User;

public interface UserService {
	
	public User addUser(User vo) throws Exception;
	
	public User loginUser(User vo) throws Exception;
	
	public User getUser(String userId) throws Exception;
	
	public Map<String,Object> getUserList(Search vo) throws Exception;
	
	public User updateUser(User vo) throws Exception;
	
	public boolean checkDuplication(String userId) throws Exception;
	
}