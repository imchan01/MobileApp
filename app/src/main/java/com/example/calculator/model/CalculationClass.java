package com.example.calculator.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
public class CalculationClass implements Parcelable {
    String solution;
    String result;

    public CalculationClass(String data, String result){
        this.solution=data;
        this.result=result;
    }

    public String getSolution(){
        return solution;
    }

    public String getResult(){
        return result;
    }
    public CalculationClass(Parcel in){
        solution = in.readString();
        result= in.readString();
    }
    @Override
    public void writeToParcel(Parcel out, int i)
    {
        out.writeString(solution);
        out.writeString(result);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    //for arrays and creating from a parcel
    public static final Parcelable.Creator<CalculationClass> CREATOR = new Parcelable.Creator<CalculationClass>() {
        public CalculationClass createFromParcel(Parcel in) {
            return new CalculationClass(in);
        }
        public CalculationClass[] newArray(int size) {
            return new CalculationClass[size];
        }
    };
}
