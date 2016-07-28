package com.ibm.hackathon.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ibm.hackathon.model.DrugNames;
@Service
public class Drugs implements IDrugs {
	@Override
	public DrugNames getDrugNamesNormalized(){
		RestTemplate restTemplate = new RestTemplate();
		DrugNames drugs = restTemplate.getForObject("https://watsonpow01.rch.stglabs.ibm.com/services/drug-info/api/v1/drugdetail/drugnames?userxcui=false", DrugNames.class);
		return drugs;
	}
}
