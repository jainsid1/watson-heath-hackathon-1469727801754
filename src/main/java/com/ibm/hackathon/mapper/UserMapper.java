package com.ibm.hackathon.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.hackathon.model.User;

public class UserMapper implements RowMapper<User> {
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setDob(new String((byte[]) rs.getObject("dob")));
		user.setEmail(new String((byte[]) rs.getObject("email")));
		user.setId(rs.getInt("id"));
		user.setMobile_number(new String((byte[]) rs.getObject("mobile_number")));
		user.setName(new String((byte[]) rs.getObject("name")));
		user.setPwd(new String((byte[]) rs.getObject("pwd")));
		user.setRole(new String((byte[]) rs.getObject("role")));
		user.setUname(new String((byte[]) rs.getObject("uname")));

		return user;
	}
}
