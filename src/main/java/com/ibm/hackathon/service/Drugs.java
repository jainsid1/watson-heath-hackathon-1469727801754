package com.ibm.hackathon.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.ibm.hackathon.model.DrugNames;
import com.ibm.hackathon.model.TradeName;
import com.ibm.hackathon.model.interaction.DrugInteraction;
@Service
public class Drugs implements IDrugs {
	
	private static final String DRUG_NAME_URL="https://watsonpow01.rch.stglabs.ibm.com/services/drug-info/api/v1/drugdetail/drugnames?userxcui=false";
	private static final String DRUG_INTERACTION_URL="http://watsonwrkp32.rch.stglabs.ibm.com:9102/services/drug-info/api/v1/drugdetail/interactions";
	private static final String DRUG_DETAILS_URI = "http://watsonwrkp32.rch.stglabs.ibm.com:9102/services/drug-info/api/v1/drugdetail/drugs/";
	private static final String DRUGS_FROM_TEXT_URL ="http://watsonwrkp32.rch.stglabs.ibm.com:9102/services/drug-info/api/v1/drugmap/drugnames?source=ATC";
	
	private static final String DRUG_FROM_TRADE_URL ="https://watsonpow01.rch.stglabs.ibm.com/services/drug-info/api/v1/drugmap/tradenames/{tradeName}/drugnames?caseSensitive=false&source=ATC";
		private static final String DRUG_TRADE_NAME_URL = "https://watsonpow01.rch.stglabs.ibm.com/services/drug-info/api/v1/drugmap/drugnames/{drugName}?caseSensitive=false&source=ATC";
				//"http://watsonwrkp32.rch.stglabs.ibm.com:9102/services/drug-info/api/v1/drugmap/tradenames/";

				@Override
	public DrugNames getDrugNamesNormalized(){
		RestTemplate restTemplate = new RestTemplate();
		DrugNames drugs = restTemplate.getForObject(DRUG_NAME_URL, DrugNames.class);
		return drugs;
	}
	@Override
	public DrugInteraction getDrugInteraction(List<String> drugNames){
		RestTemplate restTemplate = new RestTemplate();
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(DRUG_INTERACTION_URL)
			    .queryParam("drugname", drugNames.toArray(new String[0]));
		DrugInteraction drugInteration = restTemplate.getForObject(builder.toUriString(), DrugInteraction.class);
		return drugInteration;
	}

	@Override
	public List<String>  getListOfDrugsFoundInText(String text){
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<String>(text, headers);
		DrugNames names=restTemplate.postForObject(DRUGS_FROM_TEXT_URL, entity, DrugNames.class);
		return names.getData();
				
	}
	@Override
	public TradeName getDrugTradeName(String drugName){
		RestTemplate restTemplate = new RestTemplate();
//		Map<String,String> urlVar=new HashMap<>();
//		urlVar.put("drugName", drugName);
		TradeName tradeName=restTemplate.getForObject(DRUG_TRADE_NAME_URL, TradeName.class,drugName);
		//TradeName tradeName=restTemplate.getForObject(DRUG_FROM_TRADE_URI+drugName, TradeName.class);

		return tradeName;

	}
	
	public List<String> getDrugNamesFromTradeName(String tradeName){
		RestTemplate restTemplate = new RestTemplate();
		DrugNames drugNames=restTemplate.getForObject(DRUG_FROM_TRADE_URL, DrugNames.class,tradeName);
		return drugNames.getData();
	}
	

	
}
