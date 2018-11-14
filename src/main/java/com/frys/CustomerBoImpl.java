package com.frys;

public class CustomerBoImpl implements CustomerBo {

	CustomerBoImpl() {
		System.out.println("CustomerBoImpl object has been created");
	}
	
	public void addCustomer() {
		System.out.println("Adding the customer : addCustomer()");
	}

	public String addCustomerReturnValue() {
		System.out.println("Adding the customer : addCustomerReturnValue()");
		return "abc";
	}

	public void addCustomerThrowException() throws Exception {
		System.out.println("Adding the customer : addCustomerThrowException()");
		throw new Exception("Generic Error");
	}

	public void addCustomerAround(String name) {
		System.out.println("Adding the customer : addCustomerAround(name) : "+name);
		
	}

}
