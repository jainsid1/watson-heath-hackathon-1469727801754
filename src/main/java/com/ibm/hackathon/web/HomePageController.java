package com.ibm.hackathon.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ibm.hackathon.dao.ISampleDAO;
import com.ibm.hackathon.model.DrugNames;
import com.ibm.hackathon.service.IDrugs;

@Controller
@RequestMapping(value="/")

public class HomePageController {
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
		return "homePage";
	}
}