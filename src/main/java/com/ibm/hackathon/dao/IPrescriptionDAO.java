package com.ibm.hackathon.dao;

import java.util.List;

import com.ibm.hackathon.model.Prescription;

public interface IPrescriptionDAO {
	public void save(Prescription prescription);
	public List<Prescription> load(int userId);

	public void deletePrescription(int prescriptionID);
}
