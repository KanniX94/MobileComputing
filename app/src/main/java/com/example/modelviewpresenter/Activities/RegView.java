package com.example.modelviewpresenter.Activities;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.modelviewpresenter.Model.RegPresenterImpl;
import com.example.modelviewpresenter.Network.DownloadCallback;
import com.example.modelviewpresenter.Network.NetworkFragment;
import com.example.modelviewpresenter.Presenter.RegisterPresenter;
import com.example.modelviewpresenter.R;
import com.example.modelviewpresenter.View.RegisterView;


public class RegView extends AppCompatActivity implements RegisterView, DownloadCallback {

    EditText etrUserName, etrPassword, etrConfirmPassword;
    RegisterPresenter mRegisterPresenter;
    Button btnRegister, btGoToLog;


    // Keep a reference to the NetworkFragment, which owns the AsyncTask object
    // that is used to execute network ops.
    private NetworkFragment networkFragment;

    // Boolean telling us whether a download is in progress, so we don't trigger overlapping
    // downloads with consecutive button clicks.
    private boolean downloading = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        defineButton();
        etrUserName = findViewById(R.id.etrUserName);
        etrPassword = findViewById(R.id.etrPassword);
        etrConfirmPassword = findViewById(R.id.etrConfirmPassword);
        mRegisterPresenter = new RegPresenterImpl(RegView.this);

        btnRegister = findViewById(R.id.btnRegister);
        btGoToLog = findViewById(R.id.btGoToLog);
        //btnRegister.setOnClickListener(this);

        //textView = this.findViewById(R.id.textView);

        //Network fragment
        networkFragment = NetworkFragment.getInstance(getSupportFragmentManager(), "https://dev.api.digital-nursing-service.ucura.com/api/v1");

    }

    public void defineButton() {
        findViewById(R.id.btnRegister).setOnClickListener(buttonClickListener);
        findViewById(R.id.textAlreadyRegist).setOnClickListener(buttonClickListener);
        findViewById(R.id.btGoToLog).setOnClickListener(buttonClickListener);

    }

    public View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnRegister:
                    String userName = etrUserName.getText().toString();
                    String password = etrPassword.getText().toString();
                    String confirmPassword = etrConfirmPassword.getText().toString();
                    mRegisterPresenter.performRegister(userName, password, confirmPassword);
                    //mLoginPresenter.performLogin(userName, password);
                    break;
                case R.id.btGoToLog:
                    //moveToRegPage();
                    startActivity(new Intent(RegView.this, MainActivity.class));
                    break;
            }
        }
    };

    private void startDownload(int t) {
        if (!downloading && networkFragment != null) {
            // Execute the async download.
            int downloadType = t;
            networkFragment.startDownload(downloadType);
            downloading = true;


        }
    }
/*

    @Override
    public void onClick(View v) {
        //After user has put his email and pw, performRegister is called

        String userName = etrUserName.getText().toString();
        String password = etrPassword.getText().toString();
        String confirmPassword = etrConfirmPassword.getText().toString();
        mRegisterPresenter.performRegister(userName, password, confirmPassword);



}
*/

    @Override
    public void registerValidation() {

        Toast.makeText(getApplicationContext(),"Please Enter userName and Password", Toast.LENGTH_LONG).show();

    }

    @Override
    public void registerSuccess() {

        //Start download after click on register button
        startDownload(1);

        Toast.makeText(getApplicationContext(),"Register Success", Toast.LENGTH_LONG).show();
        //startActivity(new Intent(RegView.this, DataPrivacy.class));

    }

    @Override
    public void registerError() {

        Toast.makeText(getApplicationContext(),"Register Error", Toast.LENGTH_LONG).show();

    }


    @Override
    public void updateFromDownload(Object result) {
        if (result == null) {
            Toast.makeText(getApplicationContext(), "No result", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Result : " + result.toString(), Toast.LENGTH_SHORT).show();
            startActivity(new Intent(RegView.this, DataPrivacy.class));
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
        EditText mail= findViewById(R.id.etrUserName);
        return mail.getText().toString();
    }

    @Override
    public String getRegPassword() {
        EditText pw = findViewById(R.id.etrPassword);
        return pw.getText().toString();
    }

    @Override
    public String getMail() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getAccesstoken() {
        return null;
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

    //Später überarbeiten, andere Lsg falls Zeit da ist




}
