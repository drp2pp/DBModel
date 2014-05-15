package com.multicampus.minishop.services.purchase.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.multicampus.minishop.common.Search;
import com.multicampus.minishop.services.dao.abstractDAO;
import com.multicampus.minishop.services.domain.Purchase;
import com.multicampus.minishop.services.purchase.PurchaseDao;

@Repository("purchaseDaoImpl")
public class PurchaseDaoImpl extends abstractDAO implements PurchaseDao{
	//Field
	@Autowired
	@Qualifier("sqlSessionTemplate")
	protected SqlSession sqlSession;
	//Constructor
	public PurchaseDaoImpl(){
	}
	
	///Method
	public void setSqlSession(SqlSession sqlSession){
		this.sqlSession=sqlSession;
	}
	
	public int getTotalCount(Search search){
		return sqlSession.selectOne("PurchaseMapper.getTotalCount", search);
	}
	
	public int insertPurchase(Purchase purvo) throws Exception {
		return sqlSession.insert("PurchaseMapper.insertPurchase",purvo);
	}

	public Purchase findPurchase(int no) throws Exception {
		return (Purchase)sqlSession.selectOne("PurchaseMapper.findPurchase", no);
	}

	public List<Object> getPurchaseList(Search search,String buyerId) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("search", search);
		map.put("userId", buyerId);
		
		return sqlSession.selectList("PurchaseMapper.getPurchaseList", map);
	}

	public List<Object> getSaleList(Search search) throws Exception {
		List<Object> map = null;
		return map;
	}

	public int updatePurchase(Purchase purvo) throws Exception {
		return sqlSession.update("PurchaseMapper.updatePurchase", purvo);
	}
	
	public int updateTranCode(Purchase purvo) throws Exception {
		return sqlSession.update("PurchaseMapper.updateTranCode", purvo);
	}
	
	public int getTotalCount(String userId) throws Exception {
		return sqlSession.selectOne("PurchaseMapper.getTotalCount", userId);
	}
}
