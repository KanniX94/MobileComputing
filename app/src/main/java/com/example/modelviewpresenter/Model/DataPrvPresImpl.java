package com.example.modelviewpresenter.Model;

import android.widget.CheckBox;

import com.example.modelviewpresenter.Activities.DataPrivacy;
import com.example.modelviewpresenter.Presenter.DataPrvPresenter;
import com.example.modelviewpresenter.View.DataPrvView;
import com.example.modelviewpresenter.View.RegisterView;

public class DataPrvPresImpl implements DataPrvPresenter {

    DataPrvView mDataPrivacy;
    //Hier die Checkboxen abfragen rein
    CheckBox checkBox1, checkBox2;


    @Override
    public boolean checkedBoxes() {
        return false;
    }
}
