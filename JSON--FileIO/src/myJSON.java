
import Beans.Student;
import controllers.JSONController;
import controllers.JSONStudent;
import controllers.StudentInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

//import org.quickconnectfamily.json.JSONUtilities;
//import org.quickconnectfamily.json.tests.TestObject;

public class myJSON 
{

	public static void main(String[] args) 
	{
		String JSONFileName ="students.json";
		ArrayList<Student> students;
		String userInput;
		
		
		// optionally run tests
		Scanner in = new Scanner(System.in);    	
		System.out.print("Run Tests to Break Stuff? (y/n): ");     
		userInput = in.nextLine().toLowerCase();

		if (userInput.equals("y") || userInput.equals("yes"))
			letsBreakThings();

		
		// optionally load JSON
		System.out.print("Load JSON into ArrayList? (y/n): ");
		userInput = in.nextLine().toLowerCase();
		if (userInput.equals("y") || userInput.equals("yes")) 
			students = JSONStudent.loadStudentsFromJSON(JSONFileName, true);
		else
			students = new ArrayList<Student>();
		
		
		// optionally add new students
		System.out.print("Add Student(s)? (y/n): ");
		userInput = in.nextLine().toLowerCase();
		while (userInput.equals("y") || userInput.equals("yes"))
		{
			students.add(new Student(StudentInfo.getNewStudentInfo(in)));
			System.out.print("Add Another Student? (y/n): ");
			userInput = in.nextLine().toLowerCase();
//			
		}
		
		
		// optionally save to JSON
		System.out.print("Save Students to JSON? (y/n): ");     
		userInput = in.nextLine().toLowerCase();
		if (userInput.equals("y") || userInput.equals("yes"))
			JSONController.serialOut(JSONFileName,students);

		in.close();	
	}

	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	public static void letsBreakThings()
	{
		try{
			ArrayList jsonArray = new ArrayList<HashMap<String, Object>>();
			Object jsonIn = JSONController.serialIn(null);//throws null pointer Exception
			jsonArray.add(null) ; // does nothing doesn't throw an Exception
			HashMap temp = new HashMap();
			jsonArray.add(temp);
			System.out.print("jsonArray.isEmpty() : "+jsonArray.isEmpty()+"\n");
			jsonArray.remove(null);
			ArrayList stringArray = new ArrayList<String>();
			// test Iterator-ing over an empty array
			Iterator it = stringArray.iterator();
			//		it.next(); // throws no such Element Exception
			stringArray.add("ron");  	
			Iterator it2 = stringArray.iterator();
			stringArray.remove(it2.next());
			//    		stringArray.remove(it.next()); // throws ConcurrentModificationException if added element since creating iterator
			//    		it.next(); // throws ConcurrentModificationException if added element since creating iterator
			stringArray.add("bob");
			stringArray.add("bug");
			//    		for (Iterator i = stringArray.iterator(); i.hasNext();)
			//            {
			//    			jsonArray.remove(i.next());
			//            }
			//    		
		} 
		catch (Exception e) {e.printStackTrace();}  
	}

}
