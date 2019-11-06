package com.example.modelviewpresenter.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.modelviewpresenter.Model.PresenterImpl;
import com.example.modelviewpresenter.Presenter.LoginPresenter;
import com.example.modelviewpresenter.R;
import com.example.modelviewpresenter.View.LoginView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, LoginView {


    EditText etUserName, etPassword;
    TextView tvLogin;

    LoginPresenter mLoginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);
        tvLogin = findViewById(R.id.tvLogin);
        tvLogin.setOnClickListener(this);

        mLoginPresenter = new PresenterImpl(MainActivity.this);
    }

    @Override
    public void onClick(View v) {

        String userName = etUserName.getText().toString();
        String password = etPassword.getText().toString();

        mLoginPresenter.performLogin(userName, password);

    }
}
