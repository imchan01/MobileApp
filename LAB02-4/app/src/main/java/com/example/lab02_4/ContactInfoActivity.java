package com.example.lab02_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ContactInfoActivity extends AppCompatActivity {

    TextView o_name, o_email, o_project;
    Button finish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_info);
        o_name = (TextView) findViewById(R.id.o_name);
        o_email = (TextView) findViewById(R.id.o_email);
        o_project = (TextView) findViewById(R.id.o_project);
        finish = (Button) findViewById(R.id.finish);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        String email = bundle.getString("email");
        String project = bundle.getString("project");

        o_name.setText(name);
        o_email.setText(email);
        o_project.setText(project);
    }
}