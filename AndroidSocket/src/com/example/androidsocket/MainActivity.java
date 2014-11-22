package com.example.androidsocket;

import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

import com.example.androidhttp.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	int numMessagesSent = 0;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//get the UI items to interact with
		final TextView responseView = (TextView)this.findViewById(R.id.response);
		final EditText textInput = (EditText)this.findViewById(R.id.message);

		//add the on click listener to the button
		Button sendButton = (Button)this.findViewById(R.id.sendButton);
		sendButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				System.out.println("clicked");
				numMessagesSent++;
				final Handler aHandler = new Handler();
				final String serverIPAddress = "10.0.3.2"; // GenyMotion IP for the Host of the Android VM
				Thread backgroundThread = new Thread(new Runnable()
				{
					public void run()
					{
						System.out.println("backgroundThread");
						try{
							// connect to the server
							Socket toServer = new Socket(serverIPAddress, 9292);
		
							// setup the JSON streams to be used later.
							final JSONInputStream inFromServer = new JSONInputStream(toServer.getInputStream());
							final JSONOutputStream outToServer = new JSONOutputStream(toServer.getOutputStream());
							
							// prepare the bean
							ArrayList aDataList = new ArrayList();
							aDataList.add(numMessagesSent);
							aDataList.add(textInput.getText().toString());
							CommunicationBean aBean = new CommunicationBean();
							aBean.setCommand("Speak");
							aBean.setData(aDataList);
							
							//send the bean
							outToServer.writeObject(aBean);
							final HashMap aMap = (HashMap)inFromServer.readObject();
							aHandler.post(new Runnable(){
								public void run()
								{
									responseView.setText(aMap.toString());
								}
							});	
						} 
						catch(Exception e){
							final Exception ex =e;
							ex.printStackTrace();
							aHandler.post(new Runnable(){
								public void run()
								{
									responseView.setText("Error: Unable to communicate with server.");
								}
							});
						}
					}
				});
				backgroundThread.start();
			}
		});
	}
}