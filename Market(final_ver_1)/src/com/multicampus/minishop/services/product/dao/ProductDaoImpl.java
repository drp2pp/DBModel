package com.multicampus.minishop.services.product.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.multicampus.minishop.common.Search;
import com.multicampus.minishop.services.dao.abstractDAO;
import com.multicampus.minishop.services.domain.Product;
import com.multicampus.minishop.services.product.ProductDao;

@Service("productDaoImpl")
public class ProductDaoImpl extends abstractDAO implements ProductDao{
	//Field
	@Autowired
	@Qualifier("sqlSessionTemplate")
	protected SqlSession sqlSession;
	public ProductDaoImpl(){
	}
	
	///Method
	public void setSqlSession(SqlSession sqlSession){
		this.sqlSession=sqlSession;
	}
	
	public int getTotalCount(Search search){
		return sqlSession.selectOne("ProductMapper.getTotalCount", search);
	}
	public int insertProduct(Product provo) throws Exception {
		return sqlSession.insert("ProductMapper.insertProduct",provo);
	}

	public Product findProduct(int prodNo) throws Exception {
		return (Product)sqlSession.selectOne("ProductMapper.findProduct", prodNo);
	}

	public List<Object> getProductList(Search search) throws Exception {
		return sqlSession.selectList("ProductMapper.getProductList", search);
	}

	public int updateProduct(Product provo) throws Exception {
		return sqlSession.update("ProductMapper.updateProduct", provo);
	}
}
