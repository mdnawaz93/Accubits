package com.accubits.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.accubits.constant.MessageConstant;
import com.accubits.dao.BlogDao;
import com.accubits.model.BlogForm;
import com.accubits.model.UserForm;

@Controller
public class BlogController {
	@Autowired
	BlogDao blogDao;
	
	@GetMapping("/blog-list")
	public String getListOfBlog(HttpServletRequest request, ModelMap model){
		HttpSession session = request.getSession();
		
		if(session.getAttribute("userId")!=null && (int)session.getAttribute("userId")>0){
		int id = (int) session.getAttribute("userId");
		List<BlogForm> blogList = blogDao.getBlogList(id);
		model.put("blogList",blogList);
		return "BlogList";
		}else{
			return "redirect:login";
		}
		
	}

	@GetMapping("add-blog")
	public String addBlog(ModelMap model){
		model.put("blog", new BlogForm());
		return "BlogForm";
	}
	@PostMapping("save-blog")
	public String saveBlog(@ModelAttribute("blog")@Valid BlogForm blogForm,BindingResult result, ModelMap model,HttpServletRequest request ){
		if(result.hasErrors()){
			model.put("blog", blogForm);
			return "BlogForm";
		}
		HttpSession session = request.getSession();
		
		if( session.getAttribute("userObject")!=null ){
		UserForm user = (UserForm) session.getAttribute("userObject");
		blogForm.setUser(user);
		String save =blogDao.saveBlog(blogForm);
		if(save.equalsIgnoreCase(MessageConstant.success)){
			int id = (int) session.getAttribute("userId");
			model.put("blogList", blogDao.getBlogList(id));
			return "BlogList";
		}
		model.put("failMsg", "Some Problems we have");
		return "BlogForm";
		}
		else{
			model.put("user", new UserForm());
			return "Signin";
		}
	}
}
