package com.aleksandarvasilevski.android_mvp.network;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    public static final String BASE_URL = "http://192.168.1.108/connect/";

    private IRestClient restService;

    public RestClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        restService = retrofit.create(IRestClient.class);
        }

        public IRestClient getRestService(){
            return restService;
    }
}
