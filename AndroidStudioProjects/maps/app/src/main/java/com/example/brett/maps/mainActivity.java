package com.example.brett.maps;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class mainActivity extends Activity
{

    private Boolean flag = false;
    private Map<String, String> m1 = new HashMap<String,String>();

//    *************MENU STUFF**************************

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
    }

//  ****************END***********MENU STUFF*******************



    //  ************CLASS FUNCTIONS*********************
    public void addUserInput(View v)
    {

        EditText keyET = (EditText) findViewById(R.id.editText1);
        EditText valueET = (EditText) findViewById(R.id.editText2);
        this.m1.put (keyET.getText().toString(), valueET.getText().toString());
        TextView tv = (TextView) findViewById(R.id.textView1);
        tv.setText(printMap());
    }

    public void clearMap(View v)
    {
        // clear the map
        this.m1.clear();
        // change text box
        TextView tv = (TextView) findViewById(R.id.textView1);
        tv.setText(getString(R.string.textView1));
    }


    public String printMap()
    {
        String text ="The Values of the Map\n";
        if(!this.m1.isEmpty())
        {
            Set keys = this.m1.keySet();
            for (Iterator i = keys.iterator(); i.hasNext();)
            {
                String newline = "Key: [";
                String key = (String) i.next();
                newline += key;
                newline +=  "] -> Value: [";
                newline +=  this.m1.get(key);
                newline += "]\n";
                text += newline;
            }


//            Iterator it = this.m1.entrySet().iterator();
//            while (it.hasNext())
//            {
//                Map.Entry pairs = (Map.Entry) it.next();
//                text += (pairs.getKey() + " = " + pairs.getValue() + "\n");
//                it.remove(); // avoids a ConcurrentModificationException
//            }
        }
        else
        {
            text = "the Map is empty";
        }

        return text;
    }




}
