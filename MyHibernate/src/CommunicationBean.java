

import java.io.Serializable;
import java.util.ArrayList;

public class CommunicationBean implements Serializable
{
	private String command;
	private ArrayList data;
	
	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public ArrayList getData() {
		return data;
	}

	public void setData(ArrayList aData) {
		data = aData;
	}

	public CommunicationBean() {
		this.command = "";
		this.data = null;
	}

	public CommunicationBean(String aCommand, ArrayList aData) 
	{
		this.command = aCommand;
		this.data = aData;
	}

	

}
