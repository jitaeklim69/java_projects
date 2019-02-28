package org.study.crm.entity;

import java.util.Date;

// 속성
// getters/setters
// toString
// 생성자
public class Customer implements Cloneable {

	private String name;
	private String email;
	private Gender gender;
	private Date birthDate;
	
	// 생성자
	public Customer() { }
	
	public Customer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", email=" + email + ", gender=" + gender + ", birthDate=" + birthDate + "]";
	}
	
	@Override
	public Customer clone() throws CloneNotSupportedException {
		return (Customer)super.clone(); 
	}
}









