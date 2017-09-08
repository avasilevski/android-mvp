package com.aleksandarvasilevski.android_mvp.login;


import android.util.Log;

import com.aleksandarvasilevski.android_mvp.network.RestClient;
import com.aleksandarvasilevski.android_mvp.network.model.AuthenticationResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginInteractor {

    public void loginResponse(String email, String password){
        Call<AuthenticationResponse> loginCall = new RestClient().getRestService().loginUser(email, password);
        loginCall.enqueue(new Callback<AuthenticationResponse>() {
            @Override
            public void onResponse(Call<AuthenticationResponse> call, Response<AuthenticationResponse> response) {
                if (response.body() != null){
                    switch (response.code()){
                        case 200:
                            LoginPresenter.isConected = true;
                    }
                }
                Log.i("#Log", "Response Code: " + response.code());
            }

            @Override
            public void onFailure(Call<AuthenticationResponse> call, Throwable t) {
                Log.i("#Log", "Not Connected " + t.toString());
            }
        });
    }
}
