package com.example.brett.nested_collections_example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MyActivity extends Activity
{

    public List<List<String>> xyTable = new ArrayList<List<String>>();


    public String PrintTable(List<List<String>> theTable)
    {
        String returnValue = "";
        for(int x=0;x < theTable.size();x++)
        {
            for (int y = 0; y < theTable.get(x).size(); y++)
            {
                String temp = "(x,y)= (" + x + "," + y + ")\n";
                returnValue += temp;
            }
        }
    }


    public void nestedListExample(View v)
    {
        TextView tv = (TextView) findViewById(R.id.textView1);
        Button button = (Button) findViewById(R.id.button1);
        int buttonTag = (int) button.getTag().toString();

        int i=Integer.parseInt(((Button)findViewById(R.id.button1)).getText().toString().replaceAll("[\\D]", ""));

    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }

}
