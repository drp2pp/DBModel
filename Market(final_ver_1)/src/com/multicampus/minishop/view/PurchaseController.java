package com.multicampus.minishop.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.multicampus.minishop.common.Page;
import com.multicampus.minishop.common.Search;
import com.multicampus.minishop.services.domain.Product;
import com.multicampus.minishop.services.domain.Purchase;
import com.multicampus.minishop.services.domain.User;
import com.multicampus.minishop.services.product.ProductService;
import com.multicampus.minishop.services.purchase.PurchaseService;
import com.multicampus.minishop.services.purchase.impl.PurchaseServiceImpl;

@Controller
@RequestMapping("/purchase/*")
public class PurchaseController {
	@Autowired
	@Qualifier("purchaseServiceImpl")
	private PurchaseService purchaseService;
	
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;
	
	@Value("#{commonProperties['pageUnit']}") int pageUnit;
	@Value("#{commonProperties['pageSize']}") int pageSize;
	//Constructor
	public PurchaseController(){
		System.out.println("::[PurchaseController Start............]");
	}
	
	//Method
	@RequestMapping
	public String addPurchaseView(@RequestParam("prodNo") int prodNo,Model model) throws Exception {
		model.addAttribute("provo", productService.getProduct(prodNo));
		return "forward:/purchase/addPurchaseView.jsp";
	}
	
	@RequestMapping
	public String addPurchase(@ModelAttribute("purchase") Purchase purvo,HttpSession session,
								@RequestParam("prodNo") int prodNo,Model model) throws Exception {
		Product provo=productService.getProduct(prodNo);
		provo.setProTranCode("0");
		
		purvo.setPurchaseProd(provo);
		purvo.setBuyer((User)session.getAttribute("user"));
		purvo.setTranCode("0");

		purchaseService.addPurchase(purvo);
		
		model.addAttribute("purvo", purvo);
		
		return "forward:/purchase/conformPurchaseView.jsp";
	}
	
	@RequestMapping
	public String getPurchase(@RequestParam("tranNo") int tranNo,Model model) throws Exception {
		model.addAttribute("purvo", purchaseService.getPurchase(tranNo));
		return "forward:/purchase/getPurchaseView.jsp";
	}
	
	@RequestMapping
	public String updatePurchaseView(@RequestParam("tranNo") int tranNo,Model model) throws Exception {
		model.addAttribute("purvo", purchaseService.getPurchase(tranNo)); 
		return "forward:/purchase/updatePurchaseView.jsp";
	}
	
	@RequestMapping
	public String updatePurchase(@ModelAttribute("purchase") Purchase purvo,
								@RequestParam("tranNo") int tranNo,Model model) throws Exception {
		purvo.setTranNo(tranNo);
		purchaseService.updatePurchase(purvo);
		
		return "forward:/minishop/purchase/listPurchase.do";
	}
	
	@RequestMapping
	public String updateTranCode(@ModelAttribute("purchase") Purchase purvo) throws Exception {
		purchaseService.updateTranCode(purvo);
		return "redirect:/minishop/purchase/listPurchase.do";
	}
	
	@RequestMapping
	public String updateTranCodeByProd(@ModelAttribute("purchase") Purchase purvo,
										@RequestParam("prodNo") int prodNo) throws Exception {
		
		Product provo=productService.getProduct(prodNo);
		purvo.setPurchaseProd(provo);
		
		purchaseService.updateTranCode(purvo);
	
		return "redirect:/minishop/product/listProduct.do";
	}
	
	@RequestMapping
	public String listPurchase(@ModelAttribute("search") Search search,Model model,
			HttpSession session,
			@RequestParam(value="currentPage",defaultValue="1") int currentPage,
			@RequestParam(value="menu",required=false) String menu) throws Exception {
		User vo = (User)session.getAttribute("user");
		
		search.setPage(currentPage);
		search.setPageSize(pageSize);
		
		Map<String,Object> map = purchaseService.getPurchaseList(search, vo.getUserId());
		Page page = new Page(currentPage,((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize);
		
		model.addAttribute("list", (List)map.get("list"));
		model.addAttribute("search", search);
		model.addAttribute("page", page);
		
		return "forward:/purchase/listPurchaseView.jsp";
	}
}
