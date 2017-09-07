package com.aleksandarvasilevski.android_mvp.network.model;


import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("email")
    private String email;

    @SerializedName("password")
    private String password;

    @SerializedName("firstname")
    private String firstname;

    @SerializedName("lastname")
    private String lastname;

    public User(String email, String password, String firstname, String lastname){
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }
}
