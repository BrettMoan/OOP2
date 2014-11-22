package com.example.myhttpjson;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;

import org.quickconnectfamily.json.JSONException;
import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	int numMessagesSent = 0;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//get the UI items to interact with
		final TextView responseView = (TextView)this.findViewById(R.id.response);

		//add the on click listener to the button
		Button sendButton = (Button)this.findViewById(R.id.sendButton);
		sendButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				System.out.println("clicked");
				numMessagesSent++;
				final String feedUrl = "http://gdata.youtube.com/feeds/api/users/UCCaHcOauJ_q1kzq3aADoh5g/uploads?v=2&alt=jsonc&start-index=1&max-results=30";
				final Handler aHandler = new Handler();
//				final String serverIPAddress = "10.0.3.2"; // GenyMotion IP for the Host of the Android VM
				
				Thread backgroundThread = new Thread(new Runnable()
				{
					public void run()
					{

						System.out.println("backgroundThread");
						
						try{
							
							URL url = new URL(feedUrl);
							URLConnection foo = url.openConnection();
							HttpURLConnection bar = (HttpURLConnection)foo;
							
							JSONInputStream inFromHTTP = new JSONInputStream(bar.getInputStream());

							HashMap qcJSONMap = (HashMap) inFromHTTP.readObject();
							HashMap data = (HashMap) qcJSONMap.get("data");
							ArrayList items = (ArrayList)data.get("items");
							System.out.println(items.toString());
							
							String videoTitles ="Youtube Videos From CIT 360 Group\n";
							//								
							for(int i =0; i<items.size(); i++)
							{
								HashMap video = (HashMap)items.get(i);
								String s = (String)video.get("title");
								videoTitles += s + "\n";
							}

							final String finalVideoTitles = videoTitles;

							aHandler.post(new Runnable(){
								public void run()
								{
									responseView.setText(finalVideoTitles);
								}
							});	
						}
						catch(Exception e){
							final Exception ex =e;
							ex.printStackTrace();
							aHandler.post(new Runnable(){
								public void run()
								{
									responseView.setText("Error: Unable to communicate with server.\n");
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