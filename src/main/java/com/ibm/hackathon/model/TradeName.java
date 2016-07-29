package com.ibm.hackathon.model;

import java.util.List;

public class TradeName {
	String name;
	List<String> tradenames;
	List<Integer> rxCuiValues;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<String> getTradenames() {
		return tradenames;
	}
	public void setTradenames(List<String> tradenames) {
		this.tradenames = tradenames;
	}
	public List<Integer> getRxCuiValues() {
		return rxCuiValues;
	}
	public void setRxCuiValues(List<Integer> rxCuiValues) {
		this.rxCuiValues = rxCuiValues;
	}
	@Override
	public String toString() {
		return "TradeName [name=" + name + ", tradenames=" + tradenames + ", rxCuiValues=" + rxCuiValues + "]";
	}
	
	
}
