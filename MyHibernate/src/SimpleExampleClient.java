

import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

public class SimpleExampleClient {
	public int numMessagesSent = 0;
	public ArrayList aDataList = new ArrayList();

	public void communicate(String ipAddress, int Port)
	{
		String userInput="";
		Scanner in = new Scanner(System.in);    	
		boolean keepGoing = true;
		try{
			//connect to the server
			Socket toServer = new Socket(ipAddress, Port);
			//setup the JSON streams to be used later.
			final JSONInputStream inFromServer = new JSONInputStream(toServer.getInputStream());
			final JSONOutputStream outToServer = new JSONOutputStream(toServer.getOutputStream());

			while(keepGoing && toServer.isConnected())
			{
				System.out.print("Input to send to Server: ");     
				userInput = in.nextLine();
			
				numMessagesSent++;
				//prepare the bean
				aDataList.clear();
				aDataList.add(numMessagesSent);
				aDataList.add(userInput);
				CommunicationBean aBean = new CommunicationBean();
				aBean.setCommand("Speak");
				aBean.setData(aDataList);
				try {
					//send the bean
					outToServer.writeObject(aBean);
					HashMap aMap = (HashMap)inFromServer.readObject();				
//					System.out.println(aMap.toString());
					if(true)
					{
						keepGoing = false;
						toServer.close();
					}
				} catch (JSONException e) {
					e.printStackTrace();
					System.out.print("Error: Unable to trade beans with server.");
				}	
			}
			toServer.close();
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.print("Error: Unable to communicate with server. "+e.getLocalizedMessage());
		}
		
		
	}

}
