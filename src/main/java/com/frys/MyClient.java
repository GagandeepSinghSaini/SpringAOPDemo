package com.frys;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyClient {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-customer.xml");
		CustomerBo customer = (CustomerBo) context.getBean("customerBo");
		//customer.addCustomer();
		//customer.addCustomerReturnValue();
		//customer.addCustomerThrowException();
		//customer.addCustomerAround("Gagandeep Singh Saini");
		customer.addCustomerAround("Gagandeep Singh Saini");
		System.out.println("App Ends");
	}
	
}
