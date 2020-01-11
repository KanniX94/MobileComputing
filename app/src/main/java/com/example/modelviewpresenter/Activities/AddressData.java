package com.example.modelviewpresenter.Activities;

import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
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
        defineButton();
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

    private void defineButton() {
        findViewById(R.id.btnAddressNext).setOnClickListener(buttonClickListener);
    }

    public View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnPersonalNext:
                    //String gender = .getText().toString();
                    String street = etStreet.getText().toString();
                    String hausnummer = etHausnummer.getText().toString();
                    String zipCode = etZipCode.getText().toString();
                    String city = etCity.getText().toString();
                    String country = etCountry.getText().toString();
                    mAddrDataPresenter.performAddrData(street, hausnummer, zipCode, city, country);

                    //Intent intent = new Intent(AddressData.this, ReadyToStart.class);
                    //intent.putExtra(MainActivity.ACCESS_TOKEN, accesstoken);
                    //startActivity(intent);

                    break;
                case R.id.btGoToReg:
                    //mRegisterPresenter.moveToRegisterView();
                    //moveToRegPage();

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
    public String getGender() {
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

    @Override
    public void addrDataValidation() {

    }

    @Override
    public void addrDataSuccess() {

    }

    @Override
    public void addrDataError() {

    }
}
