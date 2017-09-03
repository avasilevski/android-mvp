package com.aleksandarvasilevski.android_mvp.login;


import android.util.Log;

import com.aleksandarvasilevski.android_mvp.network.IOnTaskComplete;
import com.aleksandarvasilevski.android_mvp.network.LoginTask;

public class LoginPresenter implements IOnTaskComplete {

    private ILoginView view;

    public LoginPresenter(ILoginView loginView) {
        this.view = loginView;
    }

    public void attemptLogin(String email, String password){
        LoginTask loginTask = new LoginTask();
        loginTask.delegate = this;
        loginTask.execute("login", email, password);
    }

    @Override
    public void loginResult(String output) {
        if (output.equals("200")) view.loginSuccess(); else view.loginFailed();
        Log.i("#LOG", "Connection status: " + output);
    }
}
