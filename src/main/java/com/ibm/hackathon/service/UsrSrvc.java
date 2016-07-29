package com.ibm.hackathon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.hackathon.dao.IUserDAO;
import com.ibm.hackathon.model.User;
@Service
public class UsrSrvc implements IUsrSrvc {
	@Autowired
	IUserDAO userDAO;
	
	public void save(User user){
		userDAO.save(user);
	}
	public User load(String uname){
		return userDAO.load(uname);
	}
	
	

}
