package com.aleksandarvasilevski.android_mvp.login;


import android.util.Log;

import com.aleksandarvasilevski.android_mvp.network.IOnTaskComplete;
import com.aleksandarvasilevski.android_mvp.network.LoginTask;

public class LoginPresenter implements IOnTaskComplete {

    private ILoginView view;
    public static boolean isConected = false;

    public LoginPresenter(ILoginView loginView) {
        this.view = loginView;
    }

    public void attemptLogin(String email, String password){
        LoginTask loginTask = new LoginTask();
        loginTask.delegate = this;
        loginTask.execute("login", email, password);
    }

    @Override
    public void result(String output) {
        if (output.equals("ok")) {
            view.loginSuccess();
            isConected = true;
        }else{
            view.loginFailed();
            isConected = false;
        }Log.i("#LOG", "Login status: " + output);
    }
}
