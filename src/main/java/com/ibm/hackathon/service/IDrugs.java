package com.ibm.hackathon.service;

import java.util.List;

import com.ibm.hackathon.model.DrugNames;
import com.ibm.hackathon.model.TradeName;
import com.ibm.hackathon.model.interaction.DrugInteraction;

public interface IDrugs {
	public DrugNames getDrugNamesNormalized();
	public DrugInteraction getDrugInteraction(List<String> drugNames);
	public List<String>  getListOfDrugsFoundInText(String text);
	public TradeName getDrugTradeName(String drugName);
	public List<String> getDrugNamesFromTradeName(String tradeName);
	
}
