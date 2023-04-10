package com.example.compass;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    //sensorManager use to provide method to access sensors
    private SensorManager sensorManager;
    private Sensor sensorAccelerometer; //sensor accelerometer: gia toc
    private Sensor sensorMagneticField; //sensor magneticField: tu truong


    private float[] floatGravity = new float[3]; //gia toc trong truong
    private float[] floatGeoMagnetic = new float[3]; //tu truong Trai Dat

    private float[] floatOrientation = new float[3]; // huong, xac dinh vi tri man hinh
    private float[] floatRotationMatrix = new float[9]; //xoay truc

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        //get accelerometer
        sensorAccelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        //get magneticField
        sensorMagneticField = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

        //event for listener accelrometer
        SensorEventListener sensorEventListenerAccelrometer = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                floatGravity = event.values;
                //when sensor change rotation, event get rotation and orientation
                SensorManager.getRotationMatrix(floatRotationMatrix, null, floatGravity, floatGeoMagnetic);
                SensorManager.getOrientation(floatRotationMatrix, floatOrientation);

                //Fomular to calculate Orientation of device
                //floatOrientation have 3 parameter: X,Y,Z
                //floatOrientation[0] is orientation of X
                //180 is change unit from radian to degree
                imageView.setRotation((float) (-floatOrientation[0]*180/3.14159));
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }
        };

        //event listener for magneticfield
        SensorEventListener sensorEventListenerMagneticField = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                floatGeoMagnetic = event.values;

                SensorManager.getRotationMatrix(floatRotationMatrix, null, floatGravity, floatGeoMagnetic);
                SensorManager.getOrientation(floatRotationMatrix, floatOrientation);

                imageView.setRotation((float) (-floatOrientation[0]*180/3.14159));
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }
        };
        sensorManager.registerListener(sensorEventListenerAccelrometer, sensorAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(sensorEventListenerMagneticField, sensorMagneticField, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void ResetButton(View view){

        imageView.setRotation(180);
    }
}