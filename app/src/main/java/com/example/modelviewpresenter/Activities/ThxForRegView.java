package com.example.modelviewpresenter.Activities;



import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.modelviewpresenter.Network.DownloadCallback;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.modelviewpresenter.R;

public class ThxForRegView extends AppCompatActivity {


    Button btGoToLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thxforreg);


        btGoToLogin = findViewById(R.id.btGoToLogin);
        Intent intent = new Intent(ThxForRegView.this, MainActivity.class);
        startActivity(intent);



    }



}



