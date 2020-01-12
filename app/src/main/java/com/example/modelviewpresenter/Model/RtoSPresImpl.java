package com.example.modelviewpresenter.Model;

import com.example.modelviewpresenter.Presenter.RtoSPresenter;
import com.example.modelviewpresenter.View.RtoSView;

public class RtoSPresImpl implements RtoSPresenter {


    RtoSView mRtoSView;
    public RtoSPresImpl(RtoSView rtoSView){ this.mRtoSView=rtoSView; }
}
