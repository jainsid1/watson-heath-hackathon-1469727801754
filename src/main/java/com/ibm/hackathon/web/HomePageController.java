package com.ibm.hackathon.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ibm.hackathon.dao.ISampleDAO;

@Controller
@RequestMapping(value="/")

public class HomePageController {
	@Autowired
	ISampleDAO sampleDAO;
	
	@RequestMapping(value="hello")
	public String hello(){
		System.out.println("hello");
		sampleDAO.doNothing();
		return "homePage";
	}
}