package com.ibm.hackathon.web;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibm.hackathon.model.Drug;
import com.ibm.hackathon.model.Prescription;
import com.ibm.hackathon.model.User;
import com.ibm.hackathon.service.IDrugSrvc;
import com.ibm.hackathon.service.IPrescriptionSvc;
@Controller
public class PrescriptionController {
	@Autowired
	IPrescriptionSvc prescriptionSvc;
	@Autowired
	IDrugSrvc drugSrvc;
	@ResponseBody
	@RequestMapping(value = "/prescription/add")
	public List<Drug> addPrescription(HttpSession session,@RequestParam(value="startDate") @DateTimeFormat(pattern="MM-dd-yyyy") Date startDate,@RequestParam(value="endDate") @DateTimeFormat(pattern="MM-dd-yyyy") Date endDate, @RequestParam(value="drugName") String drugName){
		User user=(User)session.getAttribute("user");
		Prescription prescription=new Prescription(user.getId(), user.getId(), startDate, endDate, new Date());
		prescriptionSvc.save(prescription);
		
		
		List<Prescription> loadedPrescription=prescriptionSvc.getAllCurrentPrescriptions(user.getId());
		Collections.sort(loadedPrescription,new Comparator<Prescription>(){
			@Override
			public int compare(Prescription p1,Prescription p2){
				if(p1.getUpload_date().before(p2.getUpload_date())){
					return -1;
				}
				else return 1;
			}
		});
		Drug drug=new Drug();
		drug.setName(drugName);
		drug.setPrescriptionID(loadedPrescription.get(loadedPrescription.size()-1).getPrescription_id());
		drugSrvc.save(drug);
		return drugSrvc.load(loadedPrescription);
	}
	@ResponseBody
	@RequestMapping(value = "/prescription/remove")
	public void removePrescription(HttpSession session,@RequestParam(value="prescriptionID")Integer prescriptionID){
		prescriptionSvc.deletePrescription(prescriptionID);
	}
}
