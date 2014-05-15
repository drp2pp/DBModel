package com.multicampus.minishop.services.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.multicampus.minishop.common.Search;
import com.multicampus.minishop.services.dao.abstractDAO;
import com.multicampus.minishop.services.domain.User;
import com.multicampus.minishop.services.user.UserDao;

@Repository("userDaoImpl")
public class UserDaoImpl extends abstractDAO implements UserDao{
	//Field
	@Autowired
	@Qualifier("sqlSessionTemplate")
	protected SqlSession sqlSession;
	
	///Constructor
	public UserDaoImpl(){
	}
	
	///Method
	public void setSqlSession(SqlSession sqlSession){
		this.sqlSession=sqlSession;
	}
	
	public int getTotalCount(Search search) throws Exception{
		return sqlSession.selectOne("UserMapper.getTotalCount", search);
	}
	
	public int insertUser(User vo) throws Exception {
		return sqlSession.insert("UserMapper.insertUser",vo);
	}

	public User findUser(String userId) throws Exception {
		return (User)sqlSession.selectOne("UserMapper.findUser", userId);
	}

	public List<Object> getUserList(Search search) throws Exception {
		return sqlSession.selectList("UserMapper.getUserList", search);		
	}

	public int updateUser(User vo) throws Exception {
		return sqlSession.update("UserMapper.updateUser", vo);
	}
}