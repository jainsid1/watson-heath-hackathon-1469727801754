package com.ibm.hackathon.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ibm.hackathon.model.User;
@Repository
public class UserDAO implements IUserDAO {
   private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//   private SimpleJdbcInsert insertUser;
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
//        this.insertUser = new SimpleJdbcInsert(dataSource)
//        		.withTableName("user")
//                .usingGeneratedKeyColumns("id");;
    }
	public void save(User user){
//		  SqlParameterSource parameters = new BeanPropertySqlParameterSource(user);
//	      Number id = insertUser.executeAndReturnKey(parameters);
	      String sql= "insert into user (name,uname, pwd,email,mobile_number,role,dob) VALUES (AES_ENCRYPT(:name, :key_str),AES_ENCRYPT(:uname, :key_str), AES_ENCRYPT(:pwd, :key_str),AES_ENCRYPT(:email, :key_str),AES_ENCRYPT(:mobile_number, :key_str),AES_ENCRYPT(:role, :key_str),AES_ENCRYPT(:dob, :key_str))";
	      Map<String,String> namedParameters = new HashMap<>();  
	      namedParameters.put("name", user.getName());   
	      namedParameters.put("uname", user.getUname());   
	      namedParameters.put("pwd", user.getPwd());
	      namedParameters.put("email", user.getEmail());
	      namedParameters.put("mobile_number", user.getMobile_number());
	      namedParameters.put("role", user.getRole());
	      namedParameters.put("dob", user.getDob());
	      namedParameters.put("key_str", "secret");
	      namedParameterJdbcTemplate.update(sql, namedParameters);	
	}
	public void load(User user){
//		  SqlParameterSource parameters = new BeanPropertySqlParameterSource(user);
//	      Number id = insertUser.executeAndReturnKey(parameters);
	      String sql= "insert into user (name,uname, pwd,email,mobile_number,role,dob) VALUES (AES_ENCRYPT(:name, :key_str),AES_ENCRYPT(:uname, :key_str), AES_ENCRYPT(:pwd, :key_str),AES_ENCRYPT(:email, :key_str),AES_ENCRYPT(:mobile_number, :key_str),AES_ENCRYPT(:role, :key_str),AES_ENCRYPT(:dob, :key_str))";
	      Map<String,String> namedParameters = new HashMap<>();  
	      namedParameters.put("name", user.getName());   
	      namedParameters.put("uname", user.getUname());   
	      namedParameters.put("pwd", user.getPwd());
	      namedParameters.put("email", user.getEmail());
	      namedParameters.put("mobile_number", user.getMobile_number());
	      namedParameters.put("role", user.getRole());
	      namedParameters.put("dob", user.getDob());
	      namedParameters.put("key_str", "secret");
	      namedParameterJdbcTemplate.update(sql, namedParameters);	
	}
	
	
	
}
