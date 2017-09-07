package com.aleksandarvasilevski.android_mvp.network;


import com.aleksandarvasilevski.android_mvp.network.model.AuthenticationResponse;
import com.aleksandarvasilevski.android_mvp.network.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IRestClient {

    @FormUrlEncoded
    @POST("login.php")
    Call<AuthenticationResponse> loginUser(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("register.php")
    Call<AuthenticationResponse> registerUser(@Field("email") String email, @Field("password") String password,
                                              @Field("firstname") String firstname, @Field("lastname") String lastname);
}
