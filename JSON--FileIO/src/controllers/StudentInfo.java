package controllers;

import java.util.HashMap;
import java.util.Scanner;

public class StudentInfo {
	public static HashMap<String, Object> getNewStudentInfo(Scanner input)
	{
		
		HashMap<String, Object> aStudentMap = new HashMap<String, Object>();
		System.out.print("First Name: ");
		aStudentMap.put("firstName", input.nextLine());
		System.out.print("Last Name: ");
		aStudentMap.put("lastName", input.nextLine());
		System.out.print("Age: ");
		aStudentMap.put("age", input.nextLong());
		System.out.print("Credits: ");
		aStudentMap.put("credits", input.nextLong());
		System.out.print("GPA: ");
		aStudentMap.put("gpa", input.nextDouble());
		input.nextLine();
		return aStudentMap;

	}
}
