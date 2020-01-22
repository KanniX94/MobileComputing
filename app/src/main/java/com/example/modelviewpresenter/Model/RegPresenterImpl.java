package com.example.modelviewpresenter.Model;
import android.text.TextUtils;
import com.example.modelviewpresenter.Presenter.RegisterPresenter;
import com.example.modelviewpresenter.View.RegisterView;



public class RegPresenterImpl implements RegisterPresenter {

    RegisterView mRegisterView;


    public RegPresenterImpl(RegisterView registerView){
        this.mRegisterView=registerView;
    }


    @Override
    public void performRegister(String userName, String password, String confirmPassword) {

        if(TextUtils.isEmpty(userName) || TextUtils.isEmpty(password) || TextUtils.isEmpty(confirmPassword)){

            mRegisterView.registerValidation();
        }
        else{

            if(password.equals(confirmPassword) && password.length() >= 8){

                //Put logic of fragment here

                mRegisterView.registerSuccess();


            }
            else{
                mRegisterView.registerError();
            }
        }

    }



}
