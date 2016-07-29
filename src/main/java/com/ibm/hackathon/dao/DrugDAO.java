package com.ibm.hackathon.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ibm.hackathon.mapper.DrugMapper;
import com.ibm.hackathon.model.Drug;
@Repository
public class DrugDAO implements IDrugDAO{
	   private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	   private static final String AES_ENCRYPTION_KEY="8DA166952A207BF784345E61B5AA82CA";
	
	    @Autowired
	    public void setDataSource(DataSource dataSource) {
	        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

	    }
	    
	    public void save(Drug drug){
//			  SqlParameterSource parameters = new BeanPropertySqlParameterSource(user);
//		      Number id = insertUser.executeAndReturnKey(parameters);
		      String sql= "insert into drugs (name, pres_id) VALUES (AES_ENCRYPT(:name, :key_str),:pres_id)";
		      Map<String,Object> namedParameters = new HashMap<>();  
		      namedParameters.put("name", drug.getName());   
		      namedParameters.put("pres_id", drug.getPrescriptionID());
		      namedParameters.put("key_str", AES_ENCRYPTION_KEY);
		      namedParameterJdbcTemplate.update(sql, namedParameters);	
		}
	    
	    public List<Drug> load(int prescriptionID){
//			  SqlParameterSource parameters = new BeanPropertySqlParameterSource(user);
//		      Number id = insertUser.executeAndReturnKey(parameters);
			  String sql= "select drugID,AES_DECRYPT(name, :key_str) as name,pres_id from drugs WHERE pres_id=:pres_id_param";

		      Map<String,Object> namedParameters = new HashMap<>();  
		      namedParameters.put("pres_id_param", prescriptionID);
		      namedParameters.put("key_str", AES_ENCRYPTION_KEY);
		      
			  List<Drug> drugs=namedParameterJdbcTemplate.query(sql, namedParameters, new DrugMapper());
			  return drugs; 
		}
	    
	    public List<Drug> load(List<Integer> prescriptionIDs){
	    	if(prescriptionIDs.isEmpty()){
	    		return Collections.<Drug>emptyList();
	    	}
//			  SqlParameterSource parameters = new BeanPropertySqlParameterSource(user);
//		      Number id = insertUser.executeAndReturnKey(parameters);
			  String sql= "select drug_id,AES_DECRYPT(name, :key_str) as name,pres_id from drugs WHERE pres_id in (:pres_id_param)";
		      Map<String,Object> namedParameters = new HashMap<>();  
		      namedParameters.put("pres_id_param", prescriptionIDs);
		      namedParameters.put("key_str", AES_ENCRYPTION_KEY);
			  List<Drug> drugs=namedParameterJdbcTemplate.query(sql, namedParameters, new DrugMapper());
			  return drugs; 
		}
	    
	    
	    
}
