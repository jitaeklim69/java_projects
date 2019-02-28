package org.study.crm.service;

import org.study.crm.entity.Customer;

public class CustomerUtilityTest {

	public static void main(String[] args) {
		CustomerUtility utility = new CustomerUtility();
		
		Customer  customer = utility.createCustomer();

		System.out.println(customer);
	}

}
