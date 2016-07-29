package com.ibm.hackathon.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.hackathon.model.User;

public class UserMapper implements RowMapper {
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {  
	/*	User user = new User();
		rs.get
		  employee.setEmpid(rs.getInt("empid"));  
		  employee.setName(rs.getString("name"));  
		  employee.setAge(rs.getInt("age"));  
		  employee.setSalary(rs.getLong("salary"));  
		  return employee;  */
		return null;
		 }  
}
