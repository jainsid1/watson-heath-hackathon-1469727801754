package com.ibm.hackathon.model;

import java.util.List;

public class TradeName {
	String name;
	List<String> tradeNames;
	List<Integer> rxCuiValues;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getTradeNames() {
		return tradeNames;
	}
	public void setTradeNames(List<String> tradeNames) {
		this.tradeNames = tradeNames;
	}
	public List<Integer> getRxCuiValues() {
		return rxCuiValues;
	}
	public void setRxCuiValues(List<Integer> rxCuiValues) {
		this.rxCuiValues = rxCuiValues;
	}
	
	
}
