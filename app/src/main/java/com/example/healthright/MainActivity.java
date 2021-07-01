package com.example.healthright;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;

import com.example.healthright.exercise.workout_age;
import com.example.healthright.shop.Shop;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity {

    String number;
    double latitude;
    double longitude;
    private Button sos_start;
    private FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        //fused location services-
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);


        sos_start = findViewById(R.id.sos_mainActivity);
        sos_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //for calling:
                //your emergency number:
                number = "112";
                String s = "tel:" + number;
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(s));
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(intent);

                //for Location:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (getApplicationContext().checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {

                        fusedLocationProviderClient.getLastLocation()
                                .addOnSuccessListener(new OnSuccessListener<Location>() {
                                    @Override
                                    public void onSuccess(Location location) {
                                        if (location != null) {
                                            latitude = location.getLatitude();
                                            longitude = location.getLongitude();

                                            sendsms();

                                        }
                                    }
                                });


                    } else
                        requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
                }
            }
        });
    }

    private void sendsms() {
        SmsManager smsManager = SmsManager.getDefault();
        String msg = "my location: http://maps.google.com/?q=" + latitude + "," + longitude;
        smsManager.sendTextMessage(number, null, msg, null, null);
    }

    public void stepcounter(View view) {
        Intent i = new Intent(this, Stepcounter.class);
        startActivity(i);
    }

    public void workoutage(View view) {
        Intent i = new Intent(this, workout_age.class);
        startActivity(i);
    }

    public void shop(View view) {
        Intent i = new Intent(this, Shop.class);
        startActivity(i);
    }

    public void bmi(View view) {
        Intent i = new Intent(this, Bmi.class);
        startActivity(i);
    }
}