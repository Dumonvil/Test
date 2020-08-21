package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;

public class  Messagge extends AppCompatActivity {

    private EditText etphone;
    private EditText etmessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messagge);

        ActivityCompat.requestPermissions(Messagge.this, new String[] {Manifest.permission.SEND_SMS, Manifest.permission.READ_SMS,Manifest.permission.READ_SMS}, PackageManager.PERMISSION_GRANTED);

        etmessage = findViewById(R.id.etmessage);
        etphone = findViewById(R.id.etphone);
    }

    public void send(View view){

        String message = etmessage.getText().toString();
        String number = etphone.getText().toString();

        SmsManager mySmsManager= SmsManager.getDefault();
        mySmsManager.sendTextMessage(number,null,message,null,null);


    }

}