package com.example.lab1_ex4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.view.View.OnKeyListener;
import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity implements OnKeyListener {
    EditText edit_text ;
    AlertDialog alert_dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         edit_text= (EditText) findViewById(R.id.editText);
        alert_dialog = new AlertDialog.Builder(this).create();
        edit_text.setOnKeyListener(this::onKey);
    }
    @Override
    public boolean onKey(View view, int keyCode, KeyEvent event) {
        if(event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER){
            String message= edit_text.getText().toString();
            alert_dialog.setMessage(message);
            alert_dialog.show();
            return true;

        }
        return false;

    }
}