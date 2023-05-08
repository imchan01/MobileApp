package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import org.apache.commons.lang3.SerializationUtils;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculator.model.CalculationClass;
import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView resultTv,solutionTv;
    MaterialButton buttonC,buttonBrackOpen,buttonBrackClose;
    MaterialButton buttonDivide,buttonMultiply,buttonPlus,buttonMinus,buttonEquals;
    MaterialButton button0,button1,button2,button3,button4,button5,button6,button7,button8,button9;
    MaterialButton buttonAC,buttonDot;

    SharedPreferences sharedPreferences;
    String fileSave = "com.example.calculator";

    int hisCount = 0 ;

//    ArrayList<String> arrayList = null;
    ArrayList<CalculationClass> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences(fileSave, MODE_PRIVATE);
        hisCount = sharedPreferences.getInt("History Count", 0);
        loadData();

        Gson gson = new Gson();
        String json=sharedPreferences.getString("History Show",null);
        Type type = new TypeToken<ArrayList<CalculationClass>>(){}.getType();
        arrayList = gson.fromJson(json,type);
        if (arrayList==null){
            arrayList=new ArrayList<>();
        }

        resultTv = findViewById(R.id.result_tv);
        solutionTv = findViewById(R.id.solution_tv);

        assignId(buttonC,R.id.button_c);
        assignId(buttonBrackOpen,R.id.button_open_bracket);
        assignId(buttonBrackClose,R.id.button_close_bracket);
        assignId(buttonDivide,R.id.button_divide);
        assignId(buttonMultiply,R.id.button_multiply);
        assignId(buttonPlus,R.id.button_plus);
        assignId(buttonMinus,R.id.button_minus);
        assignId(buttonEquals,R.id.button_equals);
        assignId(button0,R.id.button_0);
        assignId(button1,R.id.button_1);
        assignId(button2,R.id.button_2);
        assignId(button3,R.id.button_3);
        assignId(button4,R.id.button_4);
        assignId(button5,R.id.button_5);
        assignId(button6,R.id.button_6);
        assignId(button7,R.id.button_7);
        assignId(button8,R.id.button_8);
        assignId(button9,R.id.button_9);
        assignId(buttonAC,R.id.button_ac);
        assignId(buttonDot,R.id.button_dot);


    }

    private void loadData() {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("DATA", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("CALCULATION DATA", null);
        Type type = new TypeToken<ArrayList<CalculationClass>>(){}.getType();
        arrayList = gson.fromJson(json,type);

        if(arrayList.size() >10)
        {
            arrayList.remove(0);
        }
    }
    void assignId(MaterialButton btn,int id){
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        MaterialButton button =(MaterialButton) view;
        String buttonText = button.getText().toString();
        String dataToCalculate = solutionTv.getText().toString();

        if(buttonText.equals("AC")){
            solutionTv.setText("");
//            hisCount -=1;

            resultTv.setText("0");
            return;
        }
        if(buttonText.equals("C")){
            dataToCalculate = dataToCalculate.substring(0,dataToCalculate.length()-1);
        }else{
            dataToCalculate = dataToCalculate+buttonText;
        }

        if(buttonText.equals("=")){
            solutionTv.setText(resultTv.getText());
            hisCount+=1;
            String store = dataToCalculate +  resultTv.getText();
            saveData(dataToCalculate ,resultTv.getText().toString());
            return;
        }
        solutionTv.setText(dataToCalculate);

        String finalResult = getResult(dataToCalculate);

        if(!finalResult.equals("Err")){
            resultTv.setText(finalResult);
        }
    }
    String getResult(String data){
        try{
            Context context  = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
            String finalResult =  context.evaluateString(scriptable,data,"Javascript",1,null).toString();
            if(finalResult.endsWith(".0")){
                finalResult = finalResult.replace(".0","");
            }
            return finalResult;
        }catch (Exception e){
            return "Err";
        }
    }


    private void saveData(String solution, String result) {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("DATA", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();


        arrayList.add(new CalculationClass(solution, result));
        String json = gson.toJson(arrayList);
        editor.putString("CALCULATION DATA", json);
        editor.apply();
        loadData();
        notification();
    }


    public void sendIntent(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("Count Calculate", String.valueOf(hisCount));
        intent.putParcelableArrayListExtra("History", arrayList);

        startActivity(intent);
    }
    //create toast notification
    public void notification(){
        android.content.Context context = getApplicationContext();
        CharSequence text = "Save successful!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}