package com.example.modelviewpresenter.Model;

import android.text.TextUtils;

import com.example.modelviewpresenter.Presenter.LoginPresenter;
import com.example.modelviewpresenter.View.LoginView;

public class PresenterImpl implements LoginPresenter {


    LoginView mLoginView;

    public PresenterImpl(LoginView loginView){
        this.mLoginView=loginView;
    }


    @Override
    public void performLogin(String userName, String password) {

        if(TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)){

            mLoginView.loginValidation();
        }
        else{
            if(userName.equals("Sig") && password.equals("1234")){
                mLoginView.loginSuccess();

            }
            else{
                mLoginView.loginError();
            }
        }

    }
}
