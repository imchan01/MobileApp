package com.example.lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editdata);

    }
    public void writeBtn(View view) throws IOException {
        String string = "";
        StringBuilder stringBuilder = new StringBuilder();
        InputStream is = this.getResources().openRawResource(R.raw.myfile);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        while (true) {
            try {
                if ((string = reader.readLine()) == null) break;
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            stringBuilder.append(string).append(
                    "");
                    editText.setText(stringBuilder);
        }
        is.close();
        Toast.makeText(getBaseContext(), stringBuilder.toString(),
                Toast.LENGTH_LONG).show();
    }
}
