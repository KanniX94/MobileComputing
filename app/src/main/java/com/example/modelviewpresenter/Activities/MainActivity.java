package com.example.modelviewpresenter.Activities;

import androidx.appcompat.app.AppCompatActivity;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.modelviewpresenter.Model.PresenterImpl;

import com.example.modelviewpresenter.Network.DownloadCallback;
import com.example.modelviewpresenter.Network.NetworkFragment;
import com.example.modelviewpresenter.Presenter.LoginPresenter;

import com.example.modelviewpresenter.R;
import com.example.modelviewpresenter.View.LoginView;



public class MainActivity extends AppCompatActivity implements LoginView, DownloadCallback {

    public static String ACCESS_TOKEN= "ACCESS_TOKEN";
    EditText etUserName, etPassword;
    LoginPresenter mLoginPresenter;
    String accesstoken;

    // Keep a reference to the NetworkFragment, which owns the AsyncTask object
    // that is used to execute network ops.
    private NetworkFragment networkFragment;

    // Boolean telling us whether a download is in progress, so we don't trigger overlapping
    // downloads with consecutive button clicks.
    private boolean downloading = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        defineButton();
        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);
        mLoginPresenter = new PresenterImpl(MainActivity.this);
        networkFragment = NetworkFragment.getInstance(getSupportFragmentManager(), "https://dev.api.digital-nursing-service.ucura.com/api/v1");
    }

    private void startDownload(int t) {
        if (!downloading && networkFragment != null) {
            // Execute the async download.
            int downloadType = t;
            networkFragment.startDownload(downloadType);
            downloading = true;
        }
    }

    public void defineButton() {
        findViewById(R.id.tvLogin).setOnClickListener(buttonClickListener);
        findViewById(R.id.btGoToReg).setOnClickListener(buttonClickListener);

    }



    public View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tvLogin:
                    String userName = etUserName.getText().toString();
                    String password = etPassword.getText().toString();
                    mLoginPresenter.performLogin(userName, password);
                    break;
                case R.id.btGoToReg:
                    //mRegisterPresenter.moveToRegisterView();
                    //moveToRegPage();
                    startActivity(new Intent(MainActivity.this, Dashboard.class));

                    break;
            }
        }
    };

    //diese fkt auslagern später
    public void moveToRegPage(){
        startActivity(new Intent(MainActivity.this, RegView.class));
    }

    @Override
    public void loginValidation() {
        Toast.makeText(getApplicationContext(),"Please Enter userName and Password", Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginSuccess() {
        startDownload(2);
        Toast.makeText(getApplicationContext(),"Login Success", Toast.LENGTH_LONG).show();
        //startActivity(new Intent(MainActivity.this, FirstLoginView.class));
    }

    @Override
    public void loginError() {
        Toast.makeText(getApplicationContext(),"Login Error", Toast.LENGTH_LONG).show();
    }

    @Override
    public void updateFromDownload(Object result) {
        if (result == null) {
            Toast.makeText(getApplicationContext(), "No result", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Result : " + result.toString(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, FirstLoginView.class);
            accesstoken = result.toString();
            String [] parts = accesstoken.split(":");
            String[] newParts = parts[1].split(",");
            String lastParts = newParts[0].substring(1, newParts[0].length() - 1);

            intent.putExtra(this.ACCESS_TOKEN, lastParts);

            startActivity(intent);
        }
    }

    @Override
    public NetworkInfo getActiveNetworkInfo() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        Toast.makeText(getApplicationContext(), "getActiveNetworkInfo : ", Toast.LENGTH_SHORT).show();
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo;
    }

    @Override
    public void onProgressUpdate(int progressCode, int percentComplete) {

        switch(progressCode) {
            // You can add UI behavior for progress updates here.
            case Progress.ERROR:
                Toast.makeText(getApplicationContext(), "ERROR : " + progressCode, Toast.LENGTH_SHORT).show();
                break;
            case Progress.CONNECT_SUCCESS:
                Toast.makeText(getApplicationContext(), "CONNECT_SUCCESS : " + progressCode, Toast.LENGTH_SHORT).show();
                break;
            case Progress.GET_INPUT_STREAM_SUCCESS:
                Toast.makeText(getApplicationContext(), "GET_INPUT_STREAM_SUCCESS : " + progressCode, Toast.LENGTH_SHORT).show();
                break;
            case Progress.PROCESS_INPUT_STREAM_IN_PROGRESS:
                Toast.makeText(getApplicationContext(), "PROCESS_INPUT_STREAM_IN_PROGRESS : " + progressCode, Toast.LENGTH_SHORT).show();
                break;
            case Progress.PROCESS_INPUT_STREAM_SUCCESS:
                Toast.makeText(getApplicationContext(), "PROCESS_INPUT_STREAM_SUCCESS : " + progressCode, Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void finishDownloading() {
        downloading = false;
        if (networkFragment != null) {
            networkFragment.cancelDownload();
        }
    }

    @Override
    public String getRegMail() {
        return null;
    }

    @Override
    public String getRegPassword() {
        return null;
    }

    @Override
    public String getMail() {
        EditText mail= findViewById(R.id.etUserName);
        return mail.getText().toString();
    }



    @Override
    public String getPassword() {
        EditText pw = findViewById(R.id.etPassword);
        return pw.getText().toString();
    }

    @Override
    public String getAccesstoken() {
        String at = "Bearer " + accesstoken;
        return at;
    }

    @Override
    public String getNumber() {
        return null;
    }

    @Override
    public String getZip() {
        return null;
    }

    @Override
    public String getCity() {
        return null;
    }

    @Override
    public String getStreet() {
        return null;
    }

    @Override
    public String getCountry() {
        return null;
    }

    @Override
    public Integer getGender() {
        return null;
    }

    @Override
    public String getFirstname() {
        return null;
    }

    @Override
    public String getLastname() {
        return null;
    }

    @Override
    public String getBirthday() {
        return null;
    }

    @Override
    public String getPhone() {
        return null;
    }


}

