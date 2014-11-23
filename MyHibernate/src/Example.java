import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

import Controller.ACHandler;
import Controller.loginHandler;



public class Example {
	public static void main(String[] args) {
		try {
			HashMap<String, ACHandler> commandList = new HashMap<String, ACHandler>();
	    	commandList.put("login", new loginHandler());		    	
	    	
			
			//a socket opened on the specified port
			ServerSocket aListeningSocket = new ServerSocket(9292);
			Executor spool = Executors.newCachedThreadPool();
			while(true){
				//wait for a connection
				System.out.println("Waiting for client connection request.");
				final Socket clientSocket = aListeningSocket.accept();
				spool.execute(new Runnable() {
					@Override
					public void run() {
						try {
							//setup the JSON streams for later use.
							JSONInputStream inFromClient = new JSONInputStream(clientSocket.getInputStream());
							JSONOutputStream outToClient = new JSONOutputStream(clientSocket.getOutputStream());
							
							// uncomment out while loop to read until the client closes the connection. I.E. Connect Once Request Many
//							while(true){ // comment out the while loop to accept one request per connection I.E. Connect Many Request Once
							System.out.println("Waiting for a message from the server.");
							HashMap aMap = (HashMap)inFromClient.readObject();
							String command = (String) aMap.get("command");
							ArrayList data =  (ArrayList) aMap.get("data");
							ACHandler theHandler = commandList.get(command);
							if(theHandler!= null)
							{
								theHandler.handleIt(data);
							}
							
							CommunicationBean aResponse = new CommunicationBean("Done", data);
							outToClient.writeObject(aResponse);
//							 }

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
	} 
//	public static void main(String[] args) 
//		 {	 
//		    	String cmd = "";	
//		    	
//		    	HashMap<String,Object> data = new HashMap<String, Object>();
//		    	
//		    		theHandler=null;
//		    		
//		    		cmd = userInput.get("command");
//					theHandler = commandList.get(cmd);
//					
//						
//			
//	
//		    	
//		 }
//	 
}

