package com.ibm.hackathon.web;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibm.hackathon.dao.ISampleDAO;
import com.ibm.hackathon.model.Drug;
import com.ibm.hackathon.model.DrugNames;
import com.ibm.hackathon.model.Prescription;
import com.ibm.hackathon.model.User;
import com.ibm.hackathon.model.interaction.DrugInteraction;
import com.ibm.hackathon.model.patientEducation.PatientEducation;
import com.ibm.hackathon.service.IDrugSrvc;
import com.ibm.hackathon.service.IDrugs;
import com.ibm.hackathon.service.IPrescriptionSvc;
import com.ibm.hackathon.service.IUsrSrvc;

@Controller

@RequestMapping(value = "/")

public class HomePageController {
	
	@Autowired
	ISampleDAO sampleDAO;
	@Autowired
	IDrugs drugsAPI;
	@Autowired
	IUsrSrvc usrSrvc;
	@Autowired
	IPrescriptionSvc prescriptionSvc;
	@Autowired
	IDrugSrvc drugSrvc;
	@RequestMapping(value="/home")
	public String home() {
		return "homePage";
	}
	@RequestMapping(value = "test")
	public String test(Model model) {
		System.out.println("hello");
		sampleDAO.doNothing();
		DrugNames names = drugsAPI.getDrugNamesNormalized();
//		DrugInteraction drugInteraction = drugsAPI
//				.getDrugInteraction(Arrays.asList("methadone", "Venlafaxine", "cisplatin", "ibuprofen"));
		System.out.println(names.getData());
		//System.out.println(drugInteraction);
		System.out.println(drugsAPI.getListOfDrugsFoundInText("Platinum complexes are clinically used as adjuvant therapy of cancers aiming to induce tumor cell death. Depending on cell type and concentration, cisplatin induces cytotoxicity, e.g., by interference with transcription and/or DNA replication mechanisms. Additionally, cisplatin damages tumors via induction of apoptosis, mediated by the activation of various signal transduction pathways, including calcium signaling, death receptor signaling, and the activation of mitochondrial pathways. Unfortunately, neither cytotoxicity nor apoptosis are exclusively induced in cancer cells, thus, cisplatin might also lead to diverse side-effects such as neuro- and/or renal-toxicity or bone marrow-suppression. Moreover, the binding of cisplatin to proteins and enzymes may modulate its biochemical mechanism of action. While a combination-chemotherapy with cisplatin is a cornerstone for the treatment of multiple cancers, the challenge is that cancer cells could become cisplatin-resistant. Numerous mechanisms of cisplatin resistance were described including changes in cellular uptake, drug efflux, increased detoxification, inhibition of apoptosis and increased DNA repair. To minimize cisplatin resistance, combinatorial therapies were developed and have proven more effective to defeat cancers. Thus, understanding of the biochemical mechanisms triggered by cisplatin in tumor cells may lead to the design of more efficient platinum derivates (or other drugs) and might provide new therapeutic strategies and reduce side effects. "));
		System.out.println(drugsAPI.getDrugTradeName("cisplatin"));
		System.out.println(drugsAPI.getDrugNamesFromTradeName("neoplatin"));
//		User user=new User("Siddharth","sid","securedPassword#123","jas@jdkd.com","8123277163","patient","09-08-1997");
//		usrSrvc.save(user);
		User user=usrSrvc.load("sid");
		Calendar cal=Calendar.getInstance();
		Date start=cal.getTime();
		Date uploadTime=start;
		cal.add(Calendar.MONTH, 1); 
		Date endDate=cal.getTime();
		Prescription prescription=new Prescription(user.getId(),user.getId(),start,endDate,uploadTime);
	//	prescriptionSvc.save(prescription);
		List<Prescription> loadedPrescription=prescriptionSvc.getAllCurrentPrescriptions(user.getId());
//		drugSrvc.save(new Drug("cisplatin",2));
//		drugSrvc.save(new Drug("ibuprofen",2));
//		drugSrvc.save(new Drug("paracetamol",12));
//		drugSrvc.save(new Drug("aspirin",12));
//		
		

		System.out.println(loadedPrescription);
		
		System.out.println(drugSrvc.load(loadedPrescription));
		System.out.println(user);
		model.addAttribute("name","sid");
		return "homePage";
	}
	
	@ResponseBody
	@RequestMapping(value = "drug/interactions")
	public DrugInteraction getDrugInteraction(HttpSession session,@RequestParam(value="primary")  String primaryDrugName){
		List<Drug> drugs=getPrescribedDrug(session);
		List<String> drugNames=new ArrayList<String>();
		for(Drug drug:drugs){
			drugNames.add(drug.getName());
		}
		DrugInteraction interaction=drugsAPI.getDrugInteraction(drugNames,primaryDrugName);
		return interaction;
	}
	
	@ResponseBody
	@RequestMapping(value = "drug/patientEducation")
	public PatientEducation getDrugInformation(@RequestParam(value="drugName")  String drugName){
		PatientEducation information = drugsAPI.getDrugInfoForPatient(drugName);
		return information;
	}
	
	@ResponseBody
	@RequestMapping(value = "drug/prescribed")
	public List<Drug> getPrescribedDrug(HttpSession session){
		User user=(User)session.getAttribute("user");
		List<Prescription> loadedPrescription=prescriptionSvc.getAllCurrentPrescriptions(user.getId());
		return drugSrvc.load(loadedPrescription);
	}
	

}
