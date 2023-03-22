package com.example.lab1_ex3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.View.OnClickListener;
import android.content.DialogInterface;
import android.widget.Button;

import android.os.Bundle;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btn=(Button) findViewById(R.id.xemThoigian);
        final AlertDialog ad= new AlertDialog.Builder(this).create();

        btn.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {
                Date t = new Date();
                String message = "Thoi gian hien hanh " + t.toLocaleString();
                ad.setMessage(message);
                ad.show();
            }
        });
    }
}