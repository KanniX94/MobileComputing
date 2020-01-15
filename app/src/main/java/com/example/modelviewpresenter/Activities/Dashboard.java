package com.example.modelviewpresenter.Activities;



import android.content.Intent;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.modelviewpresenter.Model.DashboardPresImpl;
import com.example.modelviewpresenter.Network.DownloadCallback;
import com.example.modelviewpresenter.Network.NetworkFragment;
import com.example.modelviewpresenter.Presenter.DashboardPresenter;
import com.example.modelviewpresenter.R;
import com.example.modelviewpresenter.View.DashboardView;

public class Dashboard extends AppCompatActivity implements DashboardView, DownloadCallback {

    String accesstoken;

    String items[] = new String[] {"Alfred Nachka", "Stefan Rudinsky", "Barbara Klause", "Sigfried Holger", "Tanja Rud", "Angelina Mozek", "Wolfang Schmidt", "Paul Müller", "Lukas Gröner", "Lisa Maria Schwan", "Markus Suppes", "Fabian Burger","Sabina Matic"};

    // Keep a reference to the NetworkFragment, which owns the AsyncTask object
    // that is used to execute network ops.
    private NetworkFragment networkFragment;

    // Boolean telling us whether a download is in progress, so we don't trigger overlapping
    // downloads with consecutive button clicks.
    private boolean downloading = false;

    DashboardPresenter mDashboardPresenter;

    //Button btnAddressNext;

    ListView mListview;
    TextView mTextview;
    //RecyclerView.LayoutManager mLayoutManager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_dashboard);

        mTextview = findViewById(R.id.hiuser);
        mListview = findViewById(R.id.list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        mListview.setAdapter(adapter);

        mTextview.setText("Hi User!");

        mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Dashboard.this, items[position], Toast.LENGTH_SHORT).show();

                startActivity(new Intent(Dashboard.this, CaregiverInfo.class));

            }
        });



        mDashboardPresenter = new DashboardPresImpl(Dashboard.this);
        //defineButton();

        Intent intent = getIntent();
        accesstoken = intent.getStringExtra(MainActivity.ACCESS_TOKEN);
        networkFragment = NetworkFragment.getInstance(getSupportFragmentManager(), "https://dev.api.digital-nursing-service.ucura.com/api/v1");


        //mRecyclerView.setHasFixedSize(true);
        //mLayoutManager = new LinearLayoutManager(this);


    }

    void showCaregiverInfo(){
        startActivity(new Intent(Dashboard.this, CaregiverInfo.class));
    }


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
        return accesstoken;
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
        EditText firstname= findViewById(R.id.etPersonalName);
        return firstname.getText().toString();
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
