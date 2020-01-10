package com.example.modelviewpresenter.Activities;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.modelviewpresenter.R;
import com.example.modelviewpresenter.View.DataPrvView;

public class DataPrivacy extends AppCompatActivity implements DataPrvView {

    Button btnAccept;
    CheckBox checkbox1, checkbox2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dataprivacy);

        defineButton();
        checkedBoxes();
        btnAccept = findViewById(R.id.btnDPaccept);
    }

    public void defineButton() {
        findViewById(R.id.btnDPaccept).setOnClickListener(buttonClickListener);

    }

    public View.OnClickListener buttonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnDPaccept:
                    checkedBoxes();
                    dataPrivacyIsChecked();

                    break;
                case R.id.btGoToReg:
                    //mRegisterPresenter.moveToRegisterView();
                    //moveToRegPage();

                    break;
            }
        }
    };

    private boolean checkedBoxes() {
        checkbox1 = findViewById(R.id.checkBox1);
        checkbox2 = findViewById(R.id.checkBox2);
        if(checkbox1.isChecked() && checkbox2.isChecked()){
            return true;
        }
        else{return false;}
    }

    @Override
    public void dataPrivacyIsChecked() {

        if(checkedBoxes()==true){
            startActivity(new Intent(DataPrivacy.this, ThxForRegView.class));}
        else{
            Toast.makeText(getApplicationContext(),"Please accept all consent types!", Toast.LENGTH_LONG).show();
        }
    }

}

