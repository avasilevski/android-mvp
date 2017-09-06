package com.aleksandarvasilevski.android_mvp.network;


import com.aleksandarvasilevski.android_mvp.network.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

public interface ILoginApiClient {

    @POST("login.php")
    Call<List<User>> getUsers();
}
