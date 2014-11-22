package controllers;

import java.util.ArrayList;
import java.util.HashMap;

import Beans.Student;

public class JSONStudent {
	
	public static ArrayList<Student> loadStudentsFromJSON(String JSONFileName, boolean printToConsole)
	{
		ArrayList<HashMap<String, Object>> jsonArray = JSONController.loadFromJSON(JSONFileName);
		ArrayList<Student> students = new ArrayList<Student>();
		
		for (int i=0; i<jsonArray.size(); i++)
		{
			HashMap<String, Object> aMap = jsonArray.get(i);
			students.add(new Student(aMap));
			if(printToConsole)
			{
				System.out.print("jsonArray: ["+i+"]\n");
				System.out.print(Utility.printMap(aMap));
			}
		}
		return students;
	}
	
	public static ArrayList<Student> loadStudentsFromJSON(String JSONFileName)
	{
		return loadStudentsFromJSON(JSONFileName, false);
	}
}
