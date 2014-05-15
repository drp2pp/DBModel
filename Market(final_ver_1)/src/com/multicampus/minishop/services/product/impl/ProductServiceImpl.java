package com.multicampus.minishop.services.product.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.multicampus.minishop.common.Search;
import com.multicampus.minishop.services.domain.Product;
import com.multicampus.minishop.services.product.ProductDao;
import com.multicampus.minishop.services.product.ProductService;

@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService {
	//Field
	@Autowired
	@Qualifier("productDaoImpl")
	private ProductDao productDao;
	
	//Constructor
	public ProductServiceImpl(){
	}
	
	//Method
	public void setProductDao(ProductDao productDao){
		this.productDao=productDao;
	}
	@Override
	public Product addProduct(Product provo) throws Exception {
		productDao.insertProduct(provo);
		return provo;
	}

	@Override
	public Product getProduct(int proNo) throws Exception {
		return productDao.findProduct(proNo);
	}

	@Override
	public Map<String,Object> getProductList(Search search) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		
		int total =productDao.getTotalCount(search);
		map.put("totalCount", new Integer(total));
		
		map.put("list", productDao.getProductList(search));
		
		return map;
	}

	@Override
	public Product updateProduct(Product provo) throws Exception {
		productDao.updateProduct(provo);
		return provo;
	}
}
