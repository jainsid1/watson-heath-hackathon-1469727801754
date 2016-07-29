package com.ibm.hackathon.service;

import com.ibm.hackathon.model.User;

public interface IUsrSrvc {
	public void save(User user);
	
	public User load(String uname);
}
