package org.study.crm.service;

import java.util.Date;

import org.study.crm.entity.Customer;
import org.study.crm.entity.Gender;

public interface CRMService {
	public void printGuide();

	public void listCustomers();
	
	public Customer findCustomer(int index);
	
	public Customer[] findCustomers(String name);
	
	public void insertCustomer(Customer customer);
	
	public Customer removeCustomer(int index);
	
	public boolean removeCustomer(Customer customer);
	
	public void updateCustomer(int index, Customer customer);
	
	public void updateCustomer(int index, 
			String name, Gender gender,
			String email, Date birthDay);
}









