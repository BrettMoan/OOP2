package com.example.helloworld_brett;

import android.app.Activity;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends Activity
{

	public Boolean flag = false;
	public int aNums[], reset[] = {1,2,3,4,5,6,7,8,9};
	public int adventureCount = 0;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);        
    }
    
    
    public List<String> buildListOfAdventures()
    {
    	List<String> myList = new ArrayList<String>();
    	
    	return myList;
    	
    }
    
    
    
    public void ChangeText(View v)
    {	    	
    	if (!flag)
    		chooseAdventure(v);
    	else 
    		resetText(v);
    }  
    
    public void resetText(View v)
    {	
    	TextView text = (TextView) findViewById(R.id.textView1);
    	Button button = (Button) findViewById(R.id.button1);
    	
		text.setText(R.string.hello_world);
		button.setText(R.string.button_text);
		flag = false;
    }  
    
    public void chooseAdventure(View v)
    {

    	// reset adventure array if all values have been used.
    	if (adventureCount >= aNums.length)
    	{
    		aNums = reset;
    		adventureCount = 0;
    	}
    	
    	TextView text = (TextView) findViewById(R.id.textView1);
    	Button button = (Button) findViewById(R.id.button1);
    	button.setText(R.string.button_text2);
    	
    	Random random = new Random();
    	int i = random.nextInt(aNums.length - 1);
    	int value = aNums[i];
  
    	// gets the next value if random value gets a already used value
		while (value == 0)
	    	{
	    		i+=1;
	    		if (i >= aNums.length)
	    			i = 0;
	    		value = aNums[i];
	    	}
	    try 
	    	{
	    	//	char chr = Integer.toString(value).charAt(0);
				Class c =  Class.forName("com.example.helloworld_brett.R$string");
				Field field = c.getDeclaredField("adventure_text_" + value);
				int resId = field.getInt(null);
				String string = this.getResources().getString(resId);
				text.setText(string);
			//	text.setText("aNums.length: " + aNums.length + "adventureCount: " + adventureCount);
				
			}	
	    	catch (Exception e) 
	    	{
				e.printStackTrace();
			}
	    
	    aNums[i]=0;	
    	flag = true;
    	adventureCount+=1;
    }
     
}
