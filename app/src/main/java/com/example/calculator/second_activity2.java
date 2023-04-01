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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        Intent intent = getIntent();
        String hisCount = intent.getStringExtra("Count Calculate");

        TextView history = (TextView) findViewById(R.id.showCount);
        history.setText(  hisCount );
    }
    //cach 1
//    public String ReadFile(String FileName){
//        File path = getApplicationContext().getFilesDir();
//        File ReadFrom = new File(path, FileName);
//        byte[] content = new byte[(int ) ReadFrom.length()];
//
//        try {
//            FileInputStream Stream = new FileInputStream(ReadFrom);
//            Stream.read(content);
//            return new String(content);
//        }
//        catch (Exception e){
//            e.printStackTrace();
//            return e.toString();
//        }

    //cach 2

}
