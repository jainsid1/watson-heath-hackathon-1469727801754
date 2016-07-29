package com.ibm.hackathon.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ibm.hackathon.mapper.PrescriptionMapper;
import com.ibm.hackathon.model.Prescription;
@Repository
public class PrescriptionDAO implements IPrescriptionDAO {
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	   private static final String AES_ENCRYPTION_KEY="=A9FA7E72D0780AEB2EC6B60372C14756";
	//   private SimpleJdbcInsert insertUser;
	    @Autowired
	    public void setDataSource(DataSource dataSource) {
	        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
//	        this.insertUser = new SimpleJdbcInsert(dataSource)
//	        		.withTableName("user")
//	                .usingGeneratedKeyColumns("id");;
	    }
	


	@Override
	public void save(Prescription prescription) {
	     String sql= "insert into ad_5c709d0a555cca4.presrciption (user_id, uploaded_by,start_date,end_date,upload_date) VALUES (:user_id, :uploaded_by,AES_ENCRYPT(:startDate, :key_str),AES_ENCRYPT(:endDate, :key_str),AES_ENCRYPT(:upload_date, :key_str))";
	      Map<String,Object> namedParameters = new HashMap<>();  
	      namedParameters.put("user_id", prescription.getUser_id());   
	      namedParameters.put("uploaded_by", prescription.getUploaded_by());
	      namedParameters.put("startDate", prescription.getFormatter().format(prescription.getStartDate()));
	      namedParameters.put("endDate", prescription.getFormatter().format(prescription.getEndDate()));
	      namedParameters.put("upload_date",  prescription.getFormatter().format(prescription.getUpload_date()));
	      namedParameters.put("key_str", AES_ENCRYPTION_KEY);
	      namedParameterJdbcTemplate.update(sql, namedParameters);			
	}
	
	@Override
	public List<Prescription> load(int userId) {
	   //  String sql= "insert into prescription (user_id, uploaded_by,startDate,endDate,upload_date) VALUES (AES_ENCRYPT(:user_id, :key_str), AES_ENCRYPT(:uploaded_by, :key_str),AES_ENCRYPT(:startDate, :key_str),AES_ENCRYPT(:endDate, :key_str),AES_ENCRYPT(:upload_date, :key_str))";
	     String sql= "select prescription_id,user_id,uploaded_by,AES_DECRYPT(start_date, :key_str) as start_date,AES_DECRYPT(end_date, :key_str) as end_date,AES_DECRYPT(upload_date, :key_str) as upload_date from ad_5c709d0a555cca4.presrciption WHERE user_id=:user_id_param";
	      Map<String,Object> namedParameters = new HashMap<>();  
	      namedParameters.put("user_id_param", userId);
	      namedParameters.put("key_str", AES_ENCRYPTION_KEY);
		  List<Prescription> prescriptions=namedParameterJdbcTemplate.query(sql, namedParameters, new PrescriptionMapper());
		  return prescriptions;
	}
	
	@Override
	public void deletePrescription(int prescriptionID){
	     String sql= "DELETE FROM presrciption WHERE prescription_id = :prescriptionID";
	     Map<String,Object> namedParameters = new HashMap<>();  
	      namedParameters.put("prescriptionID", prescriptionID);
	      namedParameterJdbcTemplate.update(sql, namedParameters);
	}
	

}
