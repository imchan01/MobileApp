package com.example.lab02_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText i_name, i_email, i_project;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i_name = (EditText) findViewById(R.id.i_name);
        i_email = (EditText) findViewById(R.id.i_email);
        i_project = (EditText) findViewById(R.id.i_project);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iGetContactInfo = new Intent(getApplicationContext(), ContactInfoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", i_name.getText().toString());
                bundle.putString("email", i_email.getText().toString());
                bundle.putString("project", i_project.getText().toString());
                iGetContactInfo.putExtras(bundle);
                startActivity(iGetContactInfo);
            }
        });
    }
}