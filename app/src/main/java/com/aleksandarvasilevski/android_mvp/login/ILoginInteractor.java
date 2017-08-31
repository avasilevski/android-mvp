package com.aleksandarvasilevski.android_mvp.login;



public interface ILoginInteractor {

    boolean validatedCredentials(String email, String password);
}
