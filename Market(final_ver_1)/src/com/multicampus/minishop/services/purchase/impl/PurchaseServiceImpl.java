package com.multicampus.minishop.services.purchase.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.multicampus.minishop.common.Search;
import com.multicampus.minishop.services.domain.Product;
import com.multicampus.minishop.services.domain.Purchase;
import com.multicampus.minishop.services.domain.User;
import com.multicampus.minishop.services.product.ProductService;
import com.multicampus.minishop.services.product.impl.ProductServiceImpl;
import com.multicampus.minishop.services.purchase.PurchaseDao;
import com.multicampus.minishop.services.purchase.PurchaseService;
import com.multicampus.minishop.services.user.impl.UserServiceImpl;

@Service("purchaseServiceImpl")
public class PurchaseServiceImpl implements PurchaseService {
	//Field
	@Autowired
	@Qualifier("purchaseDaoImpl")
	private PurchaseDao purchaseDao;
	//Constructor
	public PurchaseServiceImpl(){
	}
	//Method
	public void setPurchaseDao(PurchaseDao purchaseDao){
		this.purchaseDao=purchaseDao;
	}
	@Override
	public Purchase addPurchase(Purchase purvo) throws Exception {
		purchaseDao.insertPurchase(purvo);
		return purvo;
	}
	
	@Override
	public Purchase getPurchase(int tranNo) throws Exception {
		return purchaseDao.findPurchase(tranNo);
	}

	@Override
	public Purchase getPurchase2(int ProdNo) throws Exception {
		return purchaseDao.findPurchase(ProdNo);
	}

	@Override
	public Map<String,Object> getPurchaseList(Search svo, String buyerId) throws Exception {
		Map<String,Object> map=new HashMap<String,Object>();
		int total = purchaseDao.getTotalCount(buyerId);
		
		map.put("list",purchaseDao.getPurchaseList(svo,buyerId));
		map.put("totalCount", new Integer(total));
		return map;
	}

	@Override
	public Map<String,Object> getSaleList(Search svo) throws Exception {
		Map<String,Object> map=null;
		return map;
	}

	@Override
	public Purchase updatePurchase(Purchase purvo) throws Exception {
		purchaseDao.updatePurchase(purvo);
		return purvo;
	}

	@Override
	public void updateTranCode(Purchase purvo) throws Exception {
		purchaseDao.updateTranCode(purvo);
	}

	/*public static Product transProd(int prodNo){
		Product provo=null;
		try {
			provo = new ProductServiceImpl().getProduct(prodNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return provo;
	}
	
	public static User transUser(String id){
		User vo=null;
		try {
			vo = new UserServiceImpl().getUser(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}*/

}
