package com.aleksandarvasilevski.android_mvp.register;


import android.util.Log;

import com.aleksandarvasilevski.android_mvp.network.IOnTaskComplete;
import com.aleksandarvasilevski.android_mvp.network.RegisterTask;

public class RegisterPresenter implements IOnTaskComplete {

    private IRegisterView view;
    public static boolean isRegistered = false;

    public RegisterPresenter(IRegisterView registerView){
        this.view = registerView;
    }

    public void attemptRegister(String email, String password, String firstname, String lastname){
        RegisterTask registerTask = new RegisterTask();
        registerTask.delegate = this;
        registerTask.execute("register", email, password, firstname, lastname);
    }

    @Override
    public void result(String output) {
        if (output.equals("ok")){
            view.registerSuccess();
            isRegistered = true;
        }else{
            view.registerFailed();
            isRegistered = false;
        }Log.i("#LOG", "Register status: " + output);
    }
}
