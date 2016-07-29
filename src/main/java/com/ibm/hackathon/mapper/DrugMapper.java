package com.ibm.hackathon.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.hackathon.model.Drug;

public class DrugMapper implements RowMapper<Drug>  {
	public Drug mapRow(ResultSet rs, int rowNum) throws SQLException {
		Drug drug = new Drug();
		drug.setDrugID(rs.getInt("drug_id"));
		drug.setPrescriptionID(rs.getInt("pres_id"));
		drug.setName(new String((byte[]) rs.getObject("name")));
		return drug;
	}
}
