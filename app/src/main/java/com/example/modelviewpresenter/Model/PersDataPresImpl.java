package com.example.modelviewpresenter.Model;

import android.text.TextUtils;

import com.example.modelviewpresenter.Presenter.PersDataPresenter;
import com.example.modelviewpresenter.View.PersDataView;

public class PersDataPresImpl implements PersDataPresenter {

    PersDataView mPersDataView;


    public PersDataPresImpl(PersDataView persDataView){
        this.mPersDataView=persDataView;
    }
    @Override
    public void performPersData(String gender, String firstName, String lastName, String birthday, String phone) {


        if(TextUtils.isEmpty(gender) || TextUtils.isEmpty(firstName) || TextUtils.isEmpty(lastName) || TextUtils.isEmpty(birthday) || TextUtils.isEmpty(phone)){

            mPersDataView.perDataValidation();
        }
        else{
            mPersDataView.persDataSuccess();
        }

    }
}
