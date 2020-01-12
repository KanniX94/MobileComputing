package com.example.modelviewpresenter.Model;

import com.example.modelviewpresenter.Presenter.DashboardPresenter;
import com.example.modelviewpresenter.View.DashboardView;

public class DashboardPresImpl implements DashboardPresenter {

    DashboardView mDashboardView;
    public DashboardPresImpl(DashboardView dashboardView) {this.mDashboardView=dashboardView;}
}
