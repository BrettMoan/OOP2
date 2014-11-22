package com.real.java.example;

import java.util.HashMap;
import java.util.TreeMap;

public class Business {
	protected HashMap<String, Person> employees;
	protected TreeMap<String, String> customerPhoneBook;

	public Business() {
		employees = new HashMap<String, Person>();
		customerPhoneBook = new TreeMap<String, String>();
	}

	public void addEmployee(Person aPerson) {
		if (aPerson != null && aPerson.getLastName() != null
				&& aPerson.getFirstName() != null) {
			String key = aPerson.getLastName() + ", " + aPerson.getFirstName();
			employees.put(key, aPerson);
		}
	}

	public Person getEmployee(String lastAndFirstName) {
		return employees.get(lastAndFirstName);
	}

	public void addCustomer(Person aCustomer) {
		if (aCustomer != null && aCustomer.getLastName() != null
				&& aCustomer.getFirstName() != null) {
			String key = aCustomer.getLastName() + ", "
					+ aCustomer.getFirstName();
			customerPhoneBook.put(key, aCustomer.getPhoneNumber());
		}
	}

	public String getCustomerPhoneNumber(String lastAndFirstName) {
		if (lastAndFirstName == null) {
			return null;
		}
		return customerPhoneBook.get(lastAndFirstName);
	}

	public String getAllCustomerPhoneNumbers() {
		StringBuffer phoneNumberBuffer = new StringBuffer();
		for (String aKey = customerPhoneBook.firstKey(); aKey != null; aKey = customerPhoneBook
				.higherKey(aKey)) {
			String phoneNumber = customerPhoneBook.get(aKey);
			phoneNumberBuffer.append(aKey);
			phoneNumberBuffer.append(" - ");
			phoneNumberBuffer.append(phoneNumber);
			phoneNumberBuffer.append("; ");
		}
		return phoneNumberBuffer.toString();
	}

}