package com.multicampus.minishop.services.product;

import java.util.Map;

import com.multicampus.minishop.common.Search;
import com.multicampus.minishop.services.domain.Product;

public interface ProductService {
	public Product addProduct(Product provo) throws Exception;

	public Product getProduct(int prodNo) throws Exception;

	public Map<String,Object> getProductList(Search svo) throws Exception;

	public Product updateProduct(Product provo) throws Exception;
}
