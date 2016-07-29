package com.ibm.hackathon.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ibm.hackathon.dao.ISampleDAO;
import com.ibm.hackathon.model.DrugNames;
import com.ibm.hackathon.service.IDrugs;

@Controller
@RequestMapping(value="/")

public class LoginController {
	@Autowired
	ISampleDAO sampleDAO;
	@Autowired
	IDrugs drugsAPI;

	
	@RequestMapping(value="hello")
	public String hello(){
		System.out.println("hello");
		sampleDAO.doNothing();
		DrugNames names=drugsAPI.getDrugNamesNormalized();
		System.out.println(names.getData());
		return "login";
	}
	
	@RequestMapping(value="login") 
	public String login(@RequestParam(value="username") String username, @RequestParam(value="password") String password, Model loginModel ) {
		
		if(password.equals("password")){
			loginModel.addAttribute("login","true");
			return "redirect:/landingpage";
		}
		loginModel.addAttribute("login","false");
		return "false";
		
	}
}