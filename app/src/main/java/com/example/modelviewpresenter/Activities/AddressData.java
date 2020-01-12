package com.example.modelviewpresenter.Activities;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                case R.id.btnAddressNext:
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
    public void addrDataValidation() {
        Toast.makeText(getApplicationContext(),"Register Validation", Toast.LENGTH_LONG).show();
    }

    @Override
    public void addrDataSuccess() {
        startDownload(5);
        Toast.makeText(getApplicationContext(),"Register Success", Toast.LENGTH_LONG).show();
    }

    @Override
    public void addrDataError() {
        Toast.makeText(getApplicationContext(),"Register Error", Toast.LENGTH_LONG).show();
    }

    private void startDownload(int t) {
        if (!downloading && networkFragment != null) {
            // Execute the async download.
            int downloadType = t;
            networkFragment.startDownload(downloadType);
            downloading = true;

        }
    }

    @Override
    public void updateFromDownload(Object result) {
        if (result == null) {
            Toast.makeText(getApplicationContext(), "No result", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Result : " + result.toString(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(AddressData.this, ReadyToStart.class);
            intent.putExtra(MainActivity.ACCESS_TOKEN, accesstoken);
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
    public String getAccesstoken() {
        return accesstoken;
    }

    @Override
    public String getNumber() {
        EditText number= findViewById(R.id.etHausnummer);
        return number.getText().toString();
    }

    @Override
    public String getZip() {
        EditText zipcode= findViewById(R.id.etZipCode);
        return zipcode.getText().toString();
    }

    @Override
    public String getCity() {
        EditText city= findViewById(R.id.etCity);
        return city.getText().toString();
    }

    @Override
    public String getStreet() {
        EditText street= findViewById(R.id.etStreet);
        return street.getText().toString();
    }

    @Override
    public String getCountry() {
        EditText country= findViewById(R.id.etCountry);
        return country.getText().toString();
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
