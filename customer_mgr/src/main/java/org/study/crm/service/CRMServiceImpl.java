package org.study.crm.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.study.crm.entity.Customer;
import org.study.crm.entity.Gender;

// In-Memory 구현체
public class CRMServiceImpl implements CRMService {

	List<Customer> customerList = new ArrayList<> ();
	
	@Override
	public void printGuide() {
		System.out.println("고객관리프로그램");
		System.out.println("----------------");
		System.out.println("(I)nsert, (L)ist, (U)pdate, (D)elete");
		System.out.println("(Q)uit, (G)uide");
		System.out.println("----------------");
	}

	@Override
	public void listCustomers() {
		for (int i = 0; i < customerList.size(); i++) {
			System.out.println(i + ": " 
					+ customerList.get(i));
		}
	}

	@Override
	public void insertCustomer(Customer customer) {
		customerList.add(customer);
	}

	@Override
	public Customer removeCustomer(int index) {
		if (index < 0) {
			return null;
		}
		
		if (index > customerList.size() - 1) {
			return null;
		} else {
			return customerList.remove(index);
		}
	}
	
	@Override
	public boolean removeCustomer(Customer customer) {
		return customerList.remove(customer);
	}

	@Override
	public Customer findCustomer(int index) { 
		Customer orgCustomer = customerList.get(index);
		Customer copyCustomer = null;
		try {
			copyCustomer = (Customer)orgCustomer.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		copyCustomer.setName(orgCustomer.getName());
		copyCustomer.setBirthDate(orgCustomer.getBirthDate());
		copyCustomer.setEmail(orgCustomer.getEmail());
		copyCustomer.setGender(orgCustomer.getGender());
		*/
		return copyCustomer;
	}

	@Override
	public Customer[] findCustomers(String name) {
		List<Customer> resultList = new ArrayList<> ();
		
		for (int i = 0; i < customerList.size(); i++) {
			if (name.equals(customerList.get(i).getName())) {
				try {
					resultList.add((Customer)customerList.get(i).clone());
				} catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return resultList.toArray(new Customer[0]);
	}

	@Override
	public void updateCustomer(int index, Customer customer) {
		Customer orgCustomer = customerList.get(index);
		orgCustomer.setName(customer.getName());
		orgCustomer.setBirthDate(customer.getBirthDate());
		orgCustomer.setEmail(customer.getEmail());
		orgCustomer.setGender(customer.getGender());
	}

	@Override
	public void updateCustomer(int index, String name, Gender gender, String email, Date birthDay) {
		Customer orgCustomer = customerList.get(index);
		orgCustomer.setName(name);
		orgCustomer.setBirthDate(birthDay);
		orgCustomer.setEmail(email);
		orgCustomer.setGender(gender);
		
	}
	
	
	
}











