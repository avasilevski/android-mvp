package com.aleksandarvasilevski.android_mvp.login;


import android.util.Log;

import com.aleksandarvasilevski.android_mvp.network.RestClient;
import com.aleksandarvasilevski.android_mvp.network.model.AuthenticationResponse;
import com.aleksandarvasilevski.android_mvp.network.model.User;

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
        Call<AuthenticationResponse> loginCall = new RestClient().getRestService().loginUser(email, password);
        loginCall.enqueue(new Callback<AuthenticationResponse>() {
            @Override
            public void onResponse(Call<AuthenticationResponse> call, Response<AuthenticationResponse> response) {
                if (response.body() != null){
                    switch (response.code()){
                        case 200:
                            view.loginSuccess();
                            isConected = true;
                    }
                    Log.i("#Log", "Response Code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<AuthenticationResponse> call, Throwable t) {
                view.loginFailed();
                isConected = false;
                Log.i("#Log", "Not Connected " + t.toString());
            }
        });
    }
}
