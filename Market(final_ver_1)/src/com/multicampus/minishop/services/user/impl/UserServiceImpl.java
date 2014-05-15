package com.multicampus.minishop.services.user.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.multicampus.minishop.common.Search;
import com.multicampus.minishop.services.domain.User;
import com.multicampus.minishop.services.user.UserDao;
import com.multicampus.minishop.services.user.UserService;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService{
	//Field
	@Autowired
	@Qualifier("userDaoImpl")
	private UserDao dao;
	
	//Constructor
	public UserServiceImpl() {
	}
	
	//Method
	public void setUserDao(UserDao dao){
		this.dao=dao;
	}

	public User addUser(User vo) throws Exception {
		dao.insertUser(vo);
		return vo;
	}

	public User loginUser(User vo) throws Exception {
		User dbUser=dao.findUser(vo.getUserId());
		if(dbUser==null || ! dbUser.getPassword().equals(vo.getPassword()))
			System.out.println("로그인에 실패했습니다.");
		return dbUser;
	}

	public User getUser(String userId) throws Exception {
		return dao.findUser(userId);
	}

	public Map<String,Object> getUserList(Search search) throws Exception {
		int total = dao.getTotalCount(search);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("totalCount", new Integer(total));
		map.put("list", dao.getUserList(search));
		return map;
	}

	public User updateUser(User user) throws Exception {
		dao.updateUser(user);
		return user;
	}

	public boolean checkDuplication(String userId) throws Exception {
		boolean result=true;
		User vo=dao.findUser(userId);
		if(vo != null) {
			result=false;
		}
		return result;
	}
}