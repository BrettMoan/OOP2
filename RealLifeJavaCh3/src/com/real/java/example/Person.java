package com.real.java.example;

public class Person {
	String firstName;
	String lastName;
	int age;
	String phoneNumber;

	public Person() {
	}

	public Person(String aFirstName, String aLastName, int aAge, String aPhoneNumber) 
	{
		firstName=aFirstName;
		lastName=aLastName;
		age=aAge;
		phoneNumber=aPhoneNumber;	
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (firstName == null && other.firstName != null) 
			return false;
		else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null && other.lastName != null) {
			return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (phoneNumber == null && other.phoneNumber != null) {
			return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		
		return true;
	}
}