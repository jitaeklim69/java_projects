package org.study.crm.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.study.crm.entity.Customer;
import org.study.crm.entity.Gender;

public class CustomerUtility {

	Scanner scanner = new Scanner(System.in);
	
	public Customer createCustomer() {
		System.out.print("성명: ");
		String name = scanner.nextLine();
		
		Customer customer = new Customer(name);
		
		char ch = '0';
		while (ch != 'm' && ch != 'f') {
			System.out.print("성별(M/F): ");
			String gender = scanner.nextLine();
			
			ch = gender.toLowerCase().charAt(0);
			
			if (ch == 'm') {
				customer.setGender(Gender.MALE);
				break;
			} else if (ch == 'f') {
				customer.setGender(Gender.FEMALE);
				break;
			} else {
				System.out.println("잘못 입력하였습니다.");
			}
		}
		
		System.out.print("이메일: ");
		String email = scanner.nextLine();
		
		customer.setEmail(email);
		
		System.out.print("생년월일(YYYY-MM-DD): ");
		String birthDay = scanner.nextLine();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date bDay = dateFormat.parse(birthDay);
			customer.setBirthDate(bDay);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("잘못 넣었네요...");
		}

		return customer;
	}

	public int removeCustomer() {	
		int index = -1;
		
		while (true) {
			System.out.print("삭제 고객 인덱스: ");
			String strIndex = scanner.nextLine();
			
			try {
				index = Integer.parseInt(strIndex);
				break;
			} catch(Exception e) {
				//e.printStackTrace();
				System.out.println("숫자가 아닙니다. 다시 입력하세요");
			}
		}

		return index;
	}

	public int updateCustomer() {
		int index = -1;
		
		while (true) {
			System.out.print("변경 고객 인덱스: ");
			String strIndex = scanner.nextLine();
			
			try {
				index = Integer.parseInt(strIndex);
				break;
			} catch(Exception e) {
				//e.printStackTrace();
				System.out.println("숫자가 아닙니다. 다시 입력하세요");
			}
		}

		return index;
	}
	
	public Customer updateCustomer(Customer customer) {
		System.out.println(customer);
		
		System.out.println("수정할 내용을 입력하세요");
		System.out.print("성명: ");
		String name = scanner.nextLine();
		
		if (name.length() > 0) {
			customer.setName(name);
		}
		
		char ch = '0';
		while (ch != 'm' && ch != 'f') {
			System.out.print("성별(M/F): ");
			String gender = scanner.nextLine();
			
			if (gender.length() == 0) {
				break;
			}
			ch = gender.toLowerCase().charAt(0);
			
			if (ch == 'm') {
				customer.setGender(Gender.MALE);
				break;
			} else if (ch == 'f') {
				customer.setGender(Gender.FEMALE);
				break;
			} else {
				System.out.println("잘못 입력하였습니다.");
			}
		}
		
		System.out.print("이메일: ");
		String email = scanner.nextLine();
		
		if (email.length() > 0) {
			customer.setEmail(email);
		}
		
		System.out.print("생년월일(YYYY-MM-DD): ");
		String birthDay = scanner.nextLine();
		
		if (birthDay.length() > 0) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date bDay = dateFormat.parse(birthDay);
				customer.setBirthDate(bDay);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				System.out.println("잘못 넣었네요...");
			}
		}
		
		return customer;
	}

	
}
