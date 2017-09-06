package com.aleksandarvasilevski.android_mvp.network;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginApiClient {

    public static final String BASE_URL = "http://192.168.1.108/login.php/";
    public static Retrofit retrofit = null;

    public static Retrofit getLoginApiClient(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
