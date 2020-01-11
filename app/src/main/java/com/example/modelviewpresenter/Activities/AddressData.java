package com.example.modelviewpresenter.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.modelviewpresenter.Model.AddrDataPresImpl;
import com.example.modelviewpresenter.Network.DownloadCallback;
import com.example.modelviewpresenter.Network.NetworkFragment;
import com.example.modelviewpresenter.Presenter.AddrDataPresenter;
import com.example.modelviewpresenter.R;
import com.example.modelviewpresenter.View.AddrDataView;

public class AddressData extends AppCompatActivity implements AddrDataView, DownloadCallback {

    String accesstoken;

    DownloadCallback mDC;

    // Keep a reference to the NetworkFragment, which owns the AsyncTask object
    // that is used to execute network ops.
    private NetworkFragment networkFragment;

    // Boolean telling us whether a download is in progress, so we don't trigger overlapping
    // downloads with consecutive button clicks.
    private boolean downloading = false;

    EditText etStreet, etHausnummer, etZipCode, etCity, etCountry;
    AddrDataPresenter mAddrDataPresenter;

    Button btnAddressNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_data);

        mAddrDataPresenter = new AddrDataPresImpl(AddressData.this);
        btnAddressNext= findViewById(R.id.btnAddressNext);
        etStreet = findViewById(R.id.etStreet);
        etHausnummer = findViewById(R.id.etHausnummer);
        etZipCode = findViewById(R.id.etZipCode);
        etCity = findViewById(R.id.etCity);
        etCountry = findViewById(R.id.etCountry);


        Intent intent = getIntent();
        accesstoken = intent.getStringExtra(MainActivity.ACCESS_TOKEN);


        networkFragment = NetworkFragment.getInstance(getSupportFragmentManager(), "https://dev.api.digital-nursing-service.ucura.com/api/v1");

    }
}
