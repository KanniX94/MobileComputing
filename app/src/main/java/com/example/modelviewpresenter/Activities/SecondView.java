package com.example.modelviewpresenter.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.modelviewpresenter.R;

public class SecondView extends AppCompatActivity implements View.OnClickListener {

    TextView tvLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_view);

        tvLogout = findViewById(R.id.tvLogout);
        tvLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        startActivity(new Intent(SecondView.this, MainActivity.class));
        Toast.makeText(getApplicationContext(),"Logout successful!", Toast.LENGTH_LONG).show();
    }
}
