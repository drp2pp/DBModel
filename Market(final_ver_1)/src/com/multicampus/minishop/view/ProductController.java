package com.multicampus.minishop.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.multicampus.minishop.common.Page;
import com.multicampus.minishop.common.Search;
import com.multicampus.minishop.services.domain.Product;
import com.multicampus.minishop.services.product.ProductService;

@Controller
@RequestMapping("/product/*")
public class ProductController {
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;
	
	@Value("#{commonProperties['pageUnit']}") int pageUnit;
	@Value("#{commonProperties['pageSize']}") int pageSize;
	
	//Constructor
	public ProductController(){
		System.out.println("::[ProductController Start............]");
	}
	
	//Method
	@RequestMapping
	public String addProduct(@ModelAttribute("provo") Product provo) throws Exception {
		productService.addProduct(provo);
		
		return "/minishop/product/listProduct";
	}
	
	
	@RequestMapping
	public String listProduct(@ModelAttribute("search") Search search,Model model,
								@RequestParam(value="currentPage",defaultValue="1") int currentPage,
								@RequestParam(value="menu",required=false) String menu) throws Exception {
		search.setPage(currentPage);
		search.setPageSize(pageSize);
		
		Map<String,Object> map=productService.getProductList(search);
		
		Page page=new Page(currentPage, ((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize);
		
		model.addAttribute("list", (List)map.get("list"));
		model.addAttribute("search", search);
		model.addAttribute("page", page);
		model.addAttribute("menu", menu);
		
		return "/product/listProductView.jsp?menu="+menu;
	}
	
	@RequestMapping
	public String getProduct(@RequestParam("prodNo") int prodNo,Model model,
							@CookieValue(value="history",required=false,defaultValue="") String history,
							HttpServletResponse response) throws Exception {	
		//최근에 열어본 목록 위해 쿠키 보내기
		Cookie cookie=new Cookie("history",prodNo+","+history);
		cookie.setMaxAge(-1);
		response.addCookie(cookie);
		
		//execute
		model.addAttribute("provo", productService.getProduct(prodNo));
		return "/product/getProductView.jsp";
	}
	
	@RequestMapping
	public String updateProductView(@RequestParam("prodNo") int prodNo,Model model) throws Exception {
		model.addAttribute("provo", productService.getProduct(prodNo));
		return "/product/updateProductView.jsp";
	}
	
	@RequestMapping
	public String updateProduct(@ModelAttribute("provo") Product provo,Model model) throws Exception {
		productService.updateProduct(provo);
		model.addAttribute("prodNo", provo.getProdNo());
		
		return "/minishop/product/getProduct";
	}
	
	@RequestMapping
	public String getHistory(@CookieValue(value="history",required=false) String history
							,Model model) throws Exception {	
		
//		if(history != null) {
//			String[] histories = history.split(",");
//			for (int i =histories.length-1 ; i > 0 ; i--) {
//				if (!histories[i].equals("null")){
//					
//				}
//			}
		model.addAttribute("history", history);
		return "/history.jsp";
}
}
