package com.ilp.entity;

import java.util.ArrayList;

public class Product {
	private String productCode;
	private String productName;
	private ArrayList<Services> serviceList;
	
	
	
	public Product(String productCode, String productName, ArrayList<Services> serviceList) {
		this.productCode = productCode;
		this.productName = productName;
		this.serviceList = serviceList;
	}
	
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public ArrayList<Services> getServiceList() {
		return serviceList;
	}
	public void setServiceList(ArrayList<Services> serviceList) {
		this.serviceList = serviceList;
	}
	
	
}
