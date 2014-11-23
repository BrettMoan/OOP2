

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.net.Socket;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;



// simply removing the inner while loop changes it from 
// a connect once do many


/*
 * org.quickconnectfamily.json.JSONException: Invalid JSON String
 *     at org.quickconnectfamily.json.JSONInputStream.readObject(JSONInputStream.java:103)
 *     at com.real.java.example.SimpleExampleServer$1.run(SimpleExampleServer.java:45)
 *     at java.util.concurrent.ThreadPoolExecutor.runWorker(Unknown Source)
 *     at java.util.concurrent.ThreadPoolExecutor$Worker.run(Unknown Source)
 *     at java.lang.Thread.run(Unknown Source)
 */

public class SimpleExampleServer {
	public static void main(String[] args) {
		try {
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
							//read until the client closes 
							//the connection.
//							while(true){ // opting for a Connect Many Request Once
							System.out.println("Waiting for a message from the server.");
							HashMap aMap = (HashMap)inFromClient.readObject();
							System.out.println("Just got:"+aMap+" from client"); // sometimes is throwing an an Invalid JSON String
							CommunicationBean aResponse = new CommunicationBean("Done", (ArrayList)aMap.get("data"));
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
}