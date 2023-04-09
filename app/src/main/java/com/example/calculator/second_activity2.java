package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class second_activity2 extends AppCompatActivity {

    String list[] = {"123", "listHistory"} ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        Intent intent = getIntent();
        String hisCount = intent.getStringExtra("Count Calculate");
        TextView history = (TextView) findViewById(R.id.showCount);
        history.setText( hisCount );

//        String history_key = intent.getStringExtra("History");

        //get chuoi phep tinh
        ArrayList<String> hisSolution = (ArrayList<String>) getIntent().getSerializableExtra("History") ;

        //get tung phep tinh vo item
        ListView listView = (ListView) findViewById(R.id.listHistory);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.list_history, R.id.itemHistory, hisSolution);
        listView.setAdapter(arrayAdapter);
    }
}
