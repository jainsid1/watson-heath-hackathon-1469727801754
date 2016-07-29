package com.ibm.hackathon.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	@RequestMapping(value="login",method=RequestMethod.GET) 
	public String login(){
		return "login";
	}
	
	@RequestMapping(value="home",method=RequestMethod.POST) 
	public String processLogin(@RequestParam(value="username") String username, @RequestParam(value="password") String password, Model loginModel ) {
		
		if(password.equals("password")){
			loginModel.addAttribute("login","true");
			loginModel.addAttribute("username", username);
			return "PatientPrescritpionInfo";
		}
		loginModel.addAttribute("message","Invalid username/password. Please try again.");

		return "login";
		
	}
}