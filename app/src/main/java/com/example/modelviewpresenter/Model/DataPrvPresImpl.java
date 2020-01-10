package com.example.modelviewpresenter.Model;

import android.widget.CheckBox;


import com.example.modelviewpresenter.Activities.DataPrivacy;
import com.example.modelviewpresenter.Presenter.DataPrvPresenter;
import com.example.modelviewpresenter.View.DataPrvView;
import com.example.modelviewpresenter.View.RegisterView;

public class DataPrvPresImpl implements DataPrvPresenter {

    DataPrvView mDataPrivacy;
    public DataPrvPresImpl(DataPrivacy dataPrivacy) {this.mDataPrivacy=dataPrivacy;}

    @Override
    public boolean checkedBoxes() {
        return false;
    }
}
