package com.real.java.example;

import java.net.Socket;
import java.util.ArrayList;

import org.quickconnectfamily.json.JSONInputStream;
import org.quickconnectfamily.json.JSONOutputStream;


public class SimpleSocketExample {
	int numMessagesSent = 0;
	public static void main(String[] args) 
	{
		SimpleExampleClient a = new SimpleExampleClient();
		a.communicate("127.0.0.1",9292);
	}
	

	
  
    
}
