package com.example.modelviewpresenter.Activities;

import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.modelviewpresenter.Network.DownloadCallback;
import com.example.modelviewpresenter.Network.NetworkFragment;
import com.example.modelviewpresenter.Presenter.RtoSPresenter;
import com.example.modelviewpresenter.R;
import com.example.modelviewpresenter.View.RtoSView;

public class ReadyToStart extends AppCompatActivity implements RtoSView, DownloadCallback {

    String accesstoken;

    // Keep a reference to the NetworkFragment, which owns the AsyncTask object
    // that is used to execute network ops.
    private NetworkFragment networkFragment;

    // Boolean telling us whether a download is in progress, so we don't trigger overlapping
    // downloads with consecutive button clicks.
    private boolean downloading = false;

    RtoSPresenter mRtoSPresenter;

    Button btnDone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ready_to_start);


        defineButton();
        btnDone= findViewById(R.id.btnDone);

        Intent intent = getIntent();
        accesstoken = intent.getStringExtra(MainActivity.ACCESS_TOKEN);


        networkFragment = NetworkFragment.getInstance(getSupportFragmentManager(), "https://dev.api.digital-nursing-service.ucura.com/api/v1");

    }

    public void defineButton() {
        findViewById(R.id.btnDone).setOnClickListener(buttonClickListener);
    }

    public View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnDone:

                    Intent intent = new Intent(ReadyToStart.this, Dashboard.class);
                    intent.putExtra(MainActivity.ACCESS_TOKEN, accesstoken);
                    startActivity(intent);

                    break;
            }
        }
    };


    @Override
    public void updateFromDownload(Object result) {

    }

    @Override
    public NetworkInfo getActiveNetworkInfo() {
        return null;
    }

    @Override
    public void onProgressUpdate(int progressCode, int percentComplete) {

    }

    @Override
    public void finishDownloading() {

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
}
