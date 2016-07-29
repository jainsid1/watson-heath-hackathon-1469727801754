package com.ibm.hackathon.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ibm.hackathon.mapper.UserMapper;
import com.ibm.hackathon.model.User;
@Repository
public class UserDAO implements IUserDAO {
   private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
   private static final String AES_ENCRYPTION_KEY="A017E417BB0D8167DA65B7AB5E48F6B0";
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
	      namedParameters.put("key_str", AES_ENCRYPTION_KEY);
	      namedParameterJdbcTemplate.update(sql, namedParameters);	
	}
	public User load(String uname){
//		  SqlParameterSource parameters = new BeanPropertySqlParameterSource(user);
//	      Number id = insertUser.executeAndReturnKey(parameters);
		  String sql= "select id,AES_DECRYPT(name, :key_str) as name,AES_DECRYPT(uname, :key_str) as uname, AES_DECRYPT(pwd, :key_str) as pwd,AES_DECRYPT(email, :key_str) as email,AES_DECRYPT(mobile_number, :key_str) as mobile_number,AES_DECRYPT(role, :key_str) as role,AES_DECRYPT(dob, :key_str) as dob from user WHERE CAST(AES_DECRYPT(uname,:key_str) AS CHAR)=:uname_param";
	      Map<String,String> namedParameters = new HashMap<>();  
	      namedParameters.put("uname_param", uname);
	      namedParameters.put("key_str", AES_ENCRYPTION_KEY);
		  List<User> users=namedParameterJdbcTemplate.query(sql, namedParameters, new UserMapper());
		  if(users==null){
			  users=new ArrayList<>();
			  users.add(new User("Invalid User","Invalid User",null,"","","",""));
		  }
		  return users.get(0);
	}
	
	
	
}
