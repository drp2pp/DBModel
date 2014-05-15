package com.multicampus.minishop.services.purchase;

import java.util.List;

import com.multicampus.minishop.common.Search;
import com.multicampus.minishop.services.domain.Purchase;

public interface PurchaseDao {
	public int insertPurchase(Purchase purvo) throws Exception;
	public Purchase findPurchase(int no) throws Exception;
	public List<Object> getPurchaseList(Search search,String buyerId) throws Exception;
	public List<Object> getSaleList(Search search) throws Exception;
	public int updatePurchase(Purchase purvo) throws Exception;
	public int updateTranCode(Purchase purvo) throws Exception;
	public int getTotalCount(String userId) throws Exception;
}
