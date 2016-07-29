package com.ibm.hackathon.web;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ibm.hackathon.model.Prescription;
import com.ibm.hackathon.model.User;
import com.ibm.hackathon.service.IPrescriptionSvc;
@Controller
public class PrescriptionController {
	@Autowired
	IPrescriptionSvc prescriptionSvc;
	@RequestMapping(value = "prescription/add")
	public void addPrescription(HttpSession session,@RequestParam(value="startDate") @DateTimeFormat(pattern="MM-dd-yyyy") Date startDate,@RequestParam(value="endDate") @DateTimeFormat(pattern="MM-dd-yyyy") Date endDate, @RequestParam(value="drugName") String drugName){
		User user=(User)session.getAttribute("user");
		
		Prescription prescription=new Prescription(user.getId(), user.getId(), startDate, endDate, new Date());
		prescriptionSvc.save(prescription);
	}
	@RequestMapping(value = "prescription/remove")
	public void removePrescription(HttpSession session,@RequestParam(value="prescriptionID")Integer prescriptionID){
		prescriptionSvc.deletePrescription(prescriptionID);
	}
}
