package com.example.modelviewpresenter.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.modelviewpresenter.R;

public class FirstLoginView extends AppCompatActivity {

    Button btnCompleteYourProfile;
    String accesstoken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_time_login);

        defineButton();
        btnCompleteYourProfile = findViewById(R.id.btnCompleteProfile);

        Intent intent = getIntent();
        accesstoken = intent.getStringExtra(MainActivity.ACCESS_TOKEN);

    }

    public void defineButton() {
        findViewById(R.id.btnCompleteProfile).setOnClickListener(buttonClickListener);

    }

    public View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnCompleteProfile:
                    Intent intent = new Intent(FirstLoginView.this, PersonalData.class);
                    intent.putExtra(MainActivity.ACCESS_TOKEN, accesstoken);
                    startActivity(intent);
                    break;
                case R.id.btnCGetToKnow:
                    //mRegisterPresenter.moveToRegisterView();
                    //moveToRegPage();

                    break;
            }
        }
    };

}
