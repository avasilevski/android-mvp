package com.aleksandarvasilevski.android_mvp.register;


import android.util.Log;

import com.aleksandarvasilevski.android_mvp.network.RestClient;
import com.aleksandarvasilevski.android_mvp.network.model.AuthenticationResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPresenter {

    private IRegisterView view;
    public static boolean isRegistered = false;

    public RegisterPresenter(IRegisterView registerView){
        this.view = registerView;
    }

    public void attemptRegister(String email, String password, String firstname, String lastname){
        Call<AuthenticationResponse> loginCall = new RestClient().getRestService().registerUser(email, password, firstname, lastname);
        loginCall.enqueue(new Callback<AuthenticationResponse>() {
            @Override
            public void onResponse(Call<AuthenticationResponse> call, Response<AuthenticationResponse> response) {
                if (response.body() != null){
                    switch (response.code()){
                        case 200:
                            view.registerSuccess();
                            isRegistered = true;
                    }
                    Log.i("#Log", "Response Code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<AuthenticationResponse> call, Throwable t) {
                view.registerSuccess();
                isRegistered = false;
                Log.i("#Log", "Not Registered " + t.toString());
            }
        });
    }
}
