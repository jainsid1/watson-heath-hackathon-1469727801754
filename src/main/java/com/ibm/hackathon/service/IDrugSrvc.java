package com.ibm.hackathon.service;

import java.util.List;

import com.ibm.hackathon.model.Drug;
import com.ibm.hackathon.model.Prescription;

public interface IDrugSrvc {
	public void save(Drug drug);
    public List<Drug> load(int prescriptionID);
    public List<Drug> load(List<Prescription> prescriptions);
}
