package com.ibm.hackathon.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.hackathon.dao.IPrescriptionDAO;
import com.ibm.hackathon.model.Prescription;

@Service
public class PrescriptionSvc implements IPrescriptionSvc {
	@Autowired
	IPrescriptionDAO prescriptionDAO;
	public void save(Prescription prescription){
		prescriptionDAO.save(prescription);
	}
	public List<Prescription> load(int userId){
		return prescriptionDAO.load(userId);
	}
	public List<Prescription> getAllCurrentPrescriptions(int userId){
		List<Prescription> prescriptions=load( userId);
		Iterator<Prescription> prescriptionsIt=prescriptions.iterator();
		Date currentDate=new Date();
		while(prescriptionsIt.hasNext()){
			Prescription prescription=prescriptionsIt.next();
			if( !(currentDate.after(prescription.getStartDate()) &&currentDate.before(prescription.getEndDate())) ){
				prescriptionsIt.remove();
			}
		}
		return prescriptions;
	}

}
