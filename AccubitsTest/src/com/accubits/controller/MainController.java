package com.accubits.controller;

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
import com.accubits.dao.UserDao;
import com.accubits.model.UserForm;

@Controller
public class MainController {
	
	@Autowired
	UserDao userDao;
	
	@GetMapping("/")
	public String viewIndex(ModelMap model){
		model.put("user", new UserForm());
		return "Signup";
	}

	@PostMapping("/save-user")
	public String view(@ModelAttribute("user")@Valid UserForm user, BindingResult result, ModelMap model){
		if(result.hasErrors()){
		model.put("user", user);
		return "Signup";
		}
		String save =userDao.saveUser(user);
		if(save.equalsIgnoreCase(MessageConstant.success)){
			model.put("user", new UserForm());
			return "Signin";
		}
		model.put("failMsg", "Some Problems we have");
		return "Signup";
	}
	@GetMapping("/login")
	public String getUser( ModelMap model){
		model.put("user", new UserForm());
		return "Signin";
	}
	@PostMapping("/login")
	public String login(@ModelAttribute("user") UserForm user, HttpServletRequest request,ModelMap model){
		HttpSession session = request.getSession();
		UserForm login = userDao.getUser( user);
		if(login!=null){
			session.setAttribute("userId", login.getId());
		session.setAttribute("userName", login.getName());
		session.setAttribute("userObject", login);
			return "redirect: blog-list";
		}
		model.put("failMsg", "Some Problems we have");
		return "Signin";
	}
}
