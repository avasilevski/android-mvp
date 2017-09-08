package com.aleksandarvasilevski.android_mvp.login;


public class LoginPresenter {

    private ILoginView view;
    private LoginInteractor loginInteractor = new LoginInteractor();
    public static boolean isConected = false;

    public LoginPresenter(ILoginView loginView) {
        this.view = loginView;
    }

    public void attemptLogin(String email, String password){
        loginInteractor.loginResponse(email, password);
    }
}
