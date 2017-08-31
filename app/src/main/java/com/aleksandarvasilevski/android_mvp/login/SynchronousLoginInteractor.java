package com.aleksandarvasilevski.android_mvp.login;



public class SynchronousLoginInteractor implements ILoginInteractor {

    public SynchronousLoginInteractor(){}

    public boolean validatedCredentials(String email, String password){
        return email.contains("@");
    }
}
