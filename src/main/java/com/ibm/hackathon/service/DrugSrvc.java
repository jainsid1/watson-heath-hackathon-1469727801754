package com.ibm.hackathon.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.hackathon.dao.IDrugDAO;
import com.ibm.hackathon.model.Drug;
import com.ibm.hackathon.model.Prescription;

@Service
public class DrugSrvc implements IDrugSrvc {
	@Autowired
	IDrugDAO drugDAO;
	public void save(Drug drug){
		drugDAO.save(drug);
	}
    public List<Drug> load(int prescriptionID){
    	return drugDAO.load(prescriptionID);
    }
    public List<Drug> load(List<Prescription> prescriptions){
    	List<Integer> prescriptionIDs=new ArrayList<>();
    	for(Prescription prescription:prescriptions){
    		prescriptionIDs.add(prescription.getPrescription_id());
    	}
    	return drugDAO.load(prescriptionIDs);
    }
}
