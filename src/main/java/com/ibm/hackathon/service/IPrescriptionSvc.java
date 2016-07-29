package com.ibm.hackathon.service;

import java.util.List;

import com.ibm.hackathon.model.Prescription;

public interface IPrescriptionSvc {
	public void save(Prescription prescription);
	public List<Prescription> load(int userId);
	public List<Prescription> getAllCurrentPrescriptions(int userId);
	public void deletePrescription(int prescriptionID);
}
