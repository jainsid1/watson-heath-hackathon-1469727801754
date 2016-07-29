package com.ibm.hackathon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.hackathon.dao.IDrugDAO;
import com.ibm.hackathon.model.Drug;

@Service
public class DrugSrvc {
	@Autowired
	IDrugDAO drugDAO;
	public void save(Drug drug){
		drugDAO.save(drug);
	}
    public List<Drug> load(int prescriptionID){
    	return drugDAO.load(prescriptionID);
    }
    public List<Drug> load(List<Integer> prescriptionIDs){
    	return drugDAO.load(prescriptionIDs);
    }
}
