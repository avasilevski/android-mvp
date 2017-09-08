package com.aleksandarvasilevski.android_mvp.register;


import android.util.Log;

import com.aleksandarvasilevski.android_mvp.network.RestClient;
import com.aleksandarvasilevski.android_mvp.network.model.AuthenticationResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterInteractor {

    public void attemptRegister(String email, String password, String firstname, String lastname){
        Call<AuthenticationResponse> loginCall = new RestClient().getRestService().registerUser(email, password, firstname, lastname);
        loginCall.enqueue(new Callback<AuthenticationResponse>() {
            @Override
            public void onResponse(Call<AuthenticationResponse> call, Response<AuthenticationResponse> response) {
                if (response.body() != null){
                    switch (response.code()){
                        case 200:
                            RegisterPresenter.isRegistered = true;
                    }
                    Log.i("#Log", "Response Code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<AuthenticationResponse> call, Throwable t) {
                Log.i("#Log", "Not Registered " + t.toString());
            }
        });
    }
}
