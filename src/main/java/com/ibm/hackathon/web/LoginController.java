package com.ibm.hackathon.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ibm.hackathon.dao.ISampleDAO;
import com.ibm.hackathon.model.User;
import com.ibm.hackathon.service.IDrugs;
import com.ibm.hackathon.service.IUsrSrvc;

@Controller
@RequestMapping(value="/")

public class LoginController {
	@Autowired
	ISampleDAO sampleDAO;
	@Autowired
	IDrugs drugsAPI;
	@Autowired
	IUsrSrvc usrSrvc;
	@RequestMapping(value="login",method=RequestMethod.GET) 
	public String login(){
		return "login";
	}
	
	@RequestMapping(value="home",method=RequestMethod.POST) 
	public String processLogin(HttpSession session,@RequestParam(value="username") String username, @RequestParam(value="password") String password, Model loginModel ) {
		User user = usrSrvc.load(username);
		if(user!=null && password.equals(user.getPwd())){
			loginModel.addAttribute("login","true");
			loginModel.addAttribute("username", username);
			session.setAttribute("user", user);
			return "PatientPrescritpionInfo";
		}
		loginModel.addAttribute("message","Invalid username/password. Please try again.");

		return "login";
		
	}
}