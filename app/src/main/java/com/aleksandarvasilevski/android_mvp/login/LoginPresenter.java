package com.aleksandarvasilevski.android_mvp.login;


import android.util.Log;

import com.aleksandarvasilevski.android_mvp.network.ILoginApiClient;
import com.aleksandarvasilevski.android_mvp.network.LoginApiClient;
import com.aleksandarvasilevski.android_mvp.network.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter {

    private ILoginView view;
    public static boolean isConected = false;

    public LoginPresenter(ILoginView loginView) {
        this.view = loginView;
    }

    public void attemptLogin(String email, String password){
        ILoginApiClient apiClient = LoginApiClient.getLoginApiClient().create(ILoginApiClient.class);
        Call<List<User>> call = apiClient.getUsers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                view.loginSuccess();
                isConected = true;
                Log.i("#LOG", "Connected");
            }
            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                view.loginFailed();
                isConected = false;
                Log.i("#LOG", "Not Connected");
            }
        });;
    }

//    @Override
//    public void result(String output) {
//        if (output.equals("ok")) {
//            view.loginSuccess();
//            isConected = true;
//        }else{
//            view.loginFailed();
//            isConected = false;
//        }Log.i("#LOG", "Login status: " + output);
//    }
}
