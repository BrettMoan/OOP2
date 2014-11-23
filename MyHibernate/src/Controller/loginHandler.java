package Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.jboss.marshalling.OutputStreamByteOutput;
import org.quickconnectfamily.json.JSONOutputStream;

public class loginHandler implements ACHandler {
	public boolean requiresParameters = true;
	@Override
	public void handleIt(ArrayList data) {
		try {
			
			HashMap userInfo = (HashMap) data.get(1);
			if(userInfo.containsKey("password") && userInfo.containsKey("email"))
			{
				Integer studentId = model.DatabaseFacade.getUserId(userInfo);
				if (studentId != null) 
				{
					data = model.DatabaseFacade.getStudentClasses(studentId);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
