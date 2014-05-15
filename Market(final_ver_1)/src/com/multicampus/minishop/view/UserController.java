package com.multicampus.minishop.view;

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
import org.springframework.web.servlet.ModelAndView;

import com.multicampus.minishop.common.Page;
import com.multicampus.minishop.common.Search;
import com.multicampus.minishop.services.domain.User;
import com.multicampus.minishop.services.user.UserService;

@Controller
@RequestMapping("/user/*")
public class UserController {
	//Field
	@Autowired
	@Qualifier("userServiceImpl")
	private UserService userService;

	@Value("#{commonProperties['pageUnit']}") int pageUnit;
	@Value("#{commonProperties['pageSize']}") int pageSize;
	
	//Constructor
	public UserController(){
		System.out.println("::[UserController Start............]");
	}
	
	//Method
	@RequestMapping
	public String loginView() throws Exception{
		return "redirect:/user/loginView.jsp";
	}
	
	@RequestMapping
	public String login(@ModelAttribute("user") User user,HttpSession session) 
								throws Exception {	
		User dbUser=userService.loginUser(user);
		session.setAttribute("user", dbUser);

		return "redirect:/index.jsp";
	}
	@RequestMapping
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/index.jsp";
	}
	
	@RequestMapping
	public String getUser(@RequestParam(value="userId",required=false) String userId,
								HttpSession session,Model model) throws Exception {	
		User dbUser=userId!=null?userService.getUser(userId):(User)session.getAttribute("user");
		model.addAttribute("user", dbUser);

		return "/user/getUser.jsp";
	}
	
	@RequestMapping
	public String updateUserView(@RequestParam(value="userId",required=false) String userId,
									HttpSession session,Model model) throws Exception {

		User dbUser=userId!=null?userService.getUser(userId):(User)session.getAttribute("user");
		model.addAttribute("user", dbUser);

		return "/user/updateUser.jsp";
	}
	
	@RequestMapping
	public String updateUser(@ModelAttribute("user") User user,
								HttpSession session,Model model) throws Exception {
		userService.updateUser(user);
		
		String sessionId=((User)session.getAttribute("user")).getUserId();
		if(sessionId.equals(user.getUserId()))
			session.setAttribute("user", user);
		model.addAttribute("user", user);

		return "/minishop/user/getUser?userId="+user.getUserId();
	}
	
	@RequestMapping
	public String addUserView() throws Exception {
		return "redirect:/user/addUserView.jsp";
	}
	
	@RequestMapping
	public String addUser(@ModelAttribute("user") User user) throws Exception {
		userService.addUser(user);
		return "redirect:/user/loginView.jsp";
	}
	
	@RequestMapping
	public String checkDuplication(@RequestParam(value="userId",required=false) String userId,
									Model model) throws Exception {
		boolean result=userService.checkDuplication(userId);
		model.addAttribute("userId", userId);
		model.addAttribute("result",new Boolean(result) );
		return "/user/checkDuplication.jsp";
	}
	
	@RequestMapping
	public String listUser(@ModelAttribute("search") Search search,
								@RequestParam(value="currentPage",defaultValue="1") int currentPage,
								Model model) throws Exception {
		search.setPage(currentPage);
		search.setPageSize(pageSize);
		
		Map<String,Object> map=userService.getUserList(search);
		Page page = new Page(currentPage,((Integer)map.get("totalCount")).intValue(), pageUnit, pageSize);
		
		model.addAttribute("list", map.get("list"));
		model.addAttribute("search", search);
		model.addAttribute("page", page);
		return "/user/listUser.jsp";
	}
}
