package com.ibm.hackathon.dao;

import com.ibm.hackathon.model.User;

public interface IUserDAO {
	public void save(User user);
	public User load(String uname);

}
