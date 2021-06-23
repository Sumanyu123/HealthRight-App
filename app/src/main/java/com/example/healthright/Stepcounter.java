package com.example.healthright;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class Stepcounter extends AppCompatActivity {

    TextView counter;

    double MagnitudePrevious = 0;
    private Integer step_count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stepcounter);

        counter = (TextView) findViewById(R.id.counter);
        SensorManager sensormanager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor = sensormanager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        SensorEventListener stepdetector = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if (sensorEvent != null) {
                    float x_acceleration = sensorEvent.values[0];
                    float y_acceleration = sensorEvent.values[1];
                    float z_acceleration = sensorEvent.values[2];

                    double Magnitude = Math.sqrt(x_acceleration * x_acceleration + y_acceleration * y_acceleration + z_acceleration * z_acceleration);
                    double MagnitudeDelta = Magnitude - MagnitudePrevious;
                    MagnitudePrevious = Magnitude;


                    if (MagnitudeDelta > 5) {  //threshold for walking= 6, whenever MagnitudeDelta is greater than 6, steps should increase.
                        step_count++;
                    }
                    counter.setText(step_count.toString());
                    CircularProgressBar circularProgressBar = findViewById(R.id.circularProgressBar);
                    circularProgressBar.setProgressWithAnimation(step_count);

                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };

        sensormanager.registerListener(stepdetector, sensor, SensorManager.SENSOR_DELAY_UI);

    }

    protected void onPause() {
        super.onPause();

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.putInt("step_count", step_count);
        editor.apply();
    }

    protected void onStop() {
        super.onStop();
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.putInt("step_count", step_count);
        editor.apply();

    }

    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        step_count = sharedPreferences.getInt("step_count", step_count);

        // editor.putInt("step_count",0);
        //editor.apply();
    }

    protected void onStart() {
        super.onStart();

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        step_count = sharedPreferences.getInt("step_count", 0);
        editor.putInt("step_count", 0);
        editor.apply();
    }

    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        step_count = sharedPreferences.getInt("step_count", 0);
        editor.putInt("step_count", 0);
        editor.commit();
        editor.apply();

    }

}