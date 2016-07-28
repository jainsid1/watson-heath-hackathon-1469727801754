package com.ibm.hackathon.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SampleDAO implements ISampleDAO{
	@Autowired
	private DataSource dataSource;
	
	public void doNothing(){
		System.out.println("working");
		System.out.println(dataSource);
		
		 JdbcTemplate jt = new JdbcTemplate(dataSource);
		 //jt.execute("create table sample(test char)");
	}

}
