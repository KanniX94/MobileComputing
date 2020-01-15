package com.example.modelviewpresenter.Activities;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.modelviewpresenter.R;



public class CaregiverInfo extends AppCompatActivity {

    Button btnConnect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caregiver);

        btnConnect = findViewById(R.id.btnConnect);
        defineButton();



    }

    public void defineButton() {
        findViewById(R.id.btnConnect).setOnClickListener(buttonClickListener);

    }

    public View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnConnect:
                    Toast.makeText(getApplicationContext(), "Caregiver connected ", Toast.LENGTH_SHORT).show();


                    break;
            }
        }
    };
}

