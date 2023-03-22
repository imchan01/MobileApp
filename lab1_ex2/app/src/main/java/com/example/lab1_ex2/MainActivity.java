package com.example.lab1_ex2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.content.pm.PackageManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button callButton = (Button) findViewById(R.id.callButton);
        final EditText phoneNumber = (EditText) findViewById(R.id.phoneNumber);
        callButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent =new Intent(Intent.ACTION_CALL, Uri.parse("tel:" +phoneNumber.getText()));
                callIntent.setFlags((Intent.FLAG_ACTIVITY_NEW_TASK));
                startActivity(callIntent);
            }
        });
    }

}
