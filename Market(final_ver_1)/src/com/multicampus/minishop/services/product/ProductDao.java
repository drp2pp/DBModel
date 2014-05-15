package com.multicampus.minishop.services.product;

import java.util.List;

import com.multicampus.minishop.common.Search;
import com.multicampus.minishop.services.domain.Product;

public interface ProductDao {
	public int insertProduct(Product provo) throws Exception;
	public Product findProduct(int proNo) throws Exception;
	public List<Object> getProductList(Search search) throws Exception;
	public int updateProduct(Product provo) throws Exception;
	public int getTotalCount(Search search) throws Exception;
}
