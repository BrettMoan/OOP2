package controllers;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Utility {

	@SuppressWarnings("rawtypes")
	public static String printMap(Map map)
	{
		String text ="";
		if(!map.isEmpty())
		{
			Set keys = map.keySet();
			for (Iterator i = keys.iterator(); i.hasNext();)
			{
				String newline = "Key: [";
				String key = (String) i.next();
				newline += key;
				newline +=  "] -> Value: [";
				newline +=  map.get(key);
				newline += "]\n";
				text += newline;
			}
		}
		return text;
	}

}
