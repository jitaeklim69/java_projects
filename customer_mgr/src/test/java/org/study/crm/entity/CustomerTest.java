package org.study.crm.entity;

import java.util.Calendar;
import java.util.Date;

public class CustomerTest {

	public static void main(String[] args) {
		Customer cus = new Customer("홍길동");
		
		try {
			Customer copyCus = (Customer)cus.clone();
	
			copyCus.setEmail("abc@naver.com");
			
			System.out.println(cus);
			System.out.println(copyCus);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*
		cus.setGender(Gender.MALE);
		cus.setEmail("hong@gmail.com");
		//Date now = new Date();
		//Date birthDay = Date.valueOf("1966-11-22");
		Calendar cal = Calendar.getInstance();
		cal.set(2013, 3, 15, 12, 0, 0);
		
		Date birthDay = cal.getTime();; 
		
		System.out.println(birthDay);
		cus.setBirthDate(birthDay);
		
		// deprecated
		cal.setTime(cus.getBirthDate());
		System.out.println("Year: " + cal.get(Calendar.YEAR));
		*/
	}

}
