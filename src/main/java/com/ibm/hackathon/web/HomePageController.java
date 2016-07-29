package com.ibm.hackathon.web;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ibm.hackathon.dao.ISampleDAO;
import com.ibm.hackathon.model.DrugNames;
import com.ibm.hackathon.model.interaction.DrugInteraction;
import com.ibm.hackathon.service.IDrugs;

@Controller

@RequestMapping(value = "/")

public class HomePageController {
	
	@Autowired
	ISampleDAO sampleDAO;
	@Autowired
	IDrugs drugsAPI;
	@RequestMapping(value="/home")

	public String home() {
		return "homePage";
	}
	@RequestMapping(value = "hello")
	public String hello(Model model) {
		System.out.println("hello");
		sampleDAO.doNothing();
		DrugNames names = drugsAPI.getDrugNamesNormalized();

		DrugInteraction drugInteraction = drugsAPI
				.getDrugInteraction(Arrays.asList("methadone", "Venlafaxine", "cisplatin", "ibuprofen"));
		System.out.println(names.getData());
		System.out.println(drugInteraction);
		System.out.println(drugsAPI.getListOfDrugsFoundInText("Platinum complexes are clinically used as adjuvant therapy of cancers aiming to induce tumor cell death. Depending on cell type and concentration, cisplatin induces cytotoxicity, e.g., by interference with transcription and/or DNA replication mechanisms. Additionally, cisplatin damages tumors via induction of apoptosis, mediated by the activation of various signal transduction pathways, including calcium signaling, death receptor signaling, and the activation of mitochondrial pathways. Unfortunately, neither cytotoxicity nor apoptosis are exclusively induced in cancer cells, thus, cisplatin might also lead to diverse side-effects such as neuro- and/or renal-toxicity or bone marrow-suppression. Moreover, the binding of cisplatin to proteins and enzymes may modulate its biochemical mechanism of action. While a combination-chemotherapy with cisplatin is a cornerstone for the treatment of multiple cancers, the challenge is that cancer cells could become cisplatin-resistant. Numerous mechanisms of cisplatin resistance were described including changes in cellular uptake, drug efflux, increased detoxification, inhibition of apoptosis and increased DNA repair. To minimize cisplatin resistance, combinatorial therapies were developed and have proven more effective to defeat cancers. Thus, understanding of the biochemical mechanisms triggered by cisplatin in tumor cells may lead to the design of more efficient platinum derivates (or other drugs) and might provide new therapeutic strategies and reduce side effects. "));

		model.addAttribute("name","sid");
		return "homePage";
	}

}
