package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.calculator.model.CalculationAdapter;
import com.example.calculator.model.CalculationClass;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    String list[] = {"123", "listHistory"} ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String hisCount = intent.getStringExtra("Count Calculate");
        TextView history = (TextView) findViewById(R.id.showCount);
        history.setText( hisCount );

//        String history_key = intent.getStringExtra("History");

        //get array list object
        ArrayList<CalculationClass> hisCalculation = getIntent().getParcelableArrayListExtra("History");
        CalculationAdapter solutionAdapter = new CalculationAdapter(this, hisCalculation);

        //get calculation into list view
        ListView listView = (ListView) findViewById(R.id.listHistory);
        listView.setAdapter(solutionAdapter);
    }
}
