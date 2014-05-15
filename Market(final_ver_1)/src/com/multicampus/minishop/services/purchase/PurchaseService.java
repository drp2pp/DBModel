package com.multicampus.minishop.services.purchase;

import java.util.Map;

import com.multicampus.minishop.common.Search;
import com.multicampus.minishop.services.domain.Purchase;

public interface PurchaseService {
	public Purchase addPurchase(Purchase purvo) throws Exception;
	public Purchase getPurchase(int tranNo) throws Exception;
	public Purchase getPurchase2(int ProdNo) throws Exception;
	public Map<String,Object> getPurchaseList(Search svo,String buyerId) throws Exception;
	public Map<String,Object> getSaleList(Search svo) throws Exception;
	public Purchase updatePurchase(Purchase purvo) throws Exception;
	public void updateTranCode(Purchase purvo) throws Exception;
}
