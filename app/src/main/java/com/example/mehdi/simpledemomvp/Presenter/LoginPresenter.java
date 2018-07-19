package com.example.mehdi.simpledemomvp.Presenter;

import com.example.mehdi.simpledemomvp.Model.User;
import com.example.mehdi.simpledemomvp.View.ILoginView;

public class LoginPresenter implements ILoginPresenter {


    ILoginView iLoginView;

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;

    }

    @Override
    public void onLogin(String email, String password) {
        User u = new User(email,password);
        boolean isValid = u.isValidData();
        if (isValid){
            iLoginView.onLoginResult("Login Success");
        }else {
            iLoginView.onLoginResult("Login Error");
        }
    }
}
