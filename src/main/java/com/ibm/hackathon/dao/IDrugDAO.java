package com.ibm.hackathon.dao;

import java.util.List;

import com.ibm.hackathon.model.Drug;

public interface IDrugDAO {
	public void save(Drug drug);
    public List<Drug> load(int prescriptionID);
    public List<Drug> load(List<Integer> prescriptionIDs);
}
