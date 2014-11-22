package controllers;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;


public class JSONController {

	public static void serialOut(String filename, Serializable obj) {
		try {
			File serialFile = new File(filename);
			FileOutputStream fileStream = new FileOutputStream(serialFile);
			JSONOutputStream jsonOut = new JSONOutputStream(fileStream);
			jsonOut.writeObject(obj);
			jsonOut.close();
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public static Object serialIn(String filename) 
	{
		Object json;

		try 
		{
			File serialFile = new File(filename);
			FileInputStream fileStream = new FileInputStream(serialFile);
			JSONInputStream jsonIn = new JSONInputStream(fileStream);
			json = jsonIn.readObject();
			jsonIn.close();
			return json;

		}catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	public static ArrayList<HashMap<String, Object>> loadFromJSON(String JSONFileName)
	{
		ArrayList<HashMap<String, Object>> jsonArray = new ArrayList<HashMap<String, Object>>();
		try 
		{
			Object jsonIn = JSONController.serialIn(JSONFileName);
			String className = jsonIn.getClass().getName();
			if(className.equals("java.util.HashMap")) // if JSONFileName contains only one object
			    jsonArray.add((HashMap<String, Object>)jsonIn);
			else if(className.equals("java.util.ArrayList")) // JSONFileName Contains a List of Objects
				jsonArray = (ArrayList<HashMap<String, Object>>)jsonIn;
			
		} catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
		return jsonArray;
	}
}
