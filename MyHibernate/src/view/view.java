package view;

import java.util.HashMap;
import java.util.Scanner;

import Beans.Student;
import Controller.ACHandler;
import controllers.StudentInfo;

public class view {
	
	
	
	public static HashMap<String, Object> login(Scanner input)
	{
		HashMap<String, Object> aStudentMap = new HashMap<String, Object>();
		System.out.print("Email: ");
		aStudentMap.put("email", input.nextLine());
		System.out.print("Password: ");
		aStudentMap.put("password", input.nextLine());
		return aStudentMap;
	}
	
	public static void invalidUser(HashMap<String, Object> aStudentMap)
	{
		System.out.println("Invalid password entered for email: " + aStudentMap.get("email"));	
	}
}
