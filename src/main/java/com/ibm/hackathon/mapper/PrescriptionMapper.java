package com.ibm.hackathon.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.hackathon.model.Prescription;

public class PrescriptionMapper implements RowMapper<Prescription> {
	public Prescription mapRow(ResultSet rs, int rowNum) throws SQLException{
		Prescription prescription = new Prescription();
		prescription.setUser_id(rs.getInt("user_id"));
		prescription.setPrescription_id(rs.getInt("prescription_id"));
		prescription.setUploaded_by(rs.getInt("uploaded_by"));
		try{
		prescription.setEndDate(prescription.getFormatter().parse(new String((byte[]) rs.getObject("end_date"))));
		prescription.setUpload_date(prescription.getFormatter().parse(new String((byte[]) rs.getObject("upload_date"))));
		prescription.setStartDate(prescription.getFormatter().parse(new String((byte[]) rs.getObject("start_date"))));
		}
		catch(ParseException parseEx){
			System.err.println("Failed to map Prescription with prescription ID:"+prescription.getPrescription_id());
			parseEx.printStackTrace();
		}
		return prescription;
	}
}
