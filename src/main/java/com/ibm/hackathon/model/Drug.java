package com.ibm.hackathon.model;

public class Drug {
	int drugID;
	String name;
	int prescriptionID;
	
	public Drug() {
		super();
	}
	public Drug(String name, int prescriptionID) {
		super();
		this.name = name;
		this.prescriptionID = prescriptionID;
	}
	public int getDrugID() {
		return drugID;
	}
	public void setDrugID(int drugID) {
		this.drugID = drugID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrescriptionID() {
		return prescriptionID;
	}
	public void setPrescriptionID(int prescriptionID) {
		this.prescriptionID = prescriptionID;
	}
	@Override
	public String toString() {
		return "Drug [drugID=" + drugID + ", name=" + name + ", prescriptionID=" + prescriptionID + "]";
	}
	
}
