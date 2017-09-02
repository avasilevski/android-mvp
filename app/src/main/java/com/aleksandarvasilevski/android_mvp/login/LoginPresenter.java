package com.aleksandarvasilevski.android_mvp.login;


public class LoginPresenter {

    private ILoginView view;
    private SynchronousLoginInteractor interactor;

    public LoginPresenter(ILoginView loginView) {
        this.view = loginView;
        this.interactor = new SynchronousLoginInteractor();
    }

    public void attemptLogin(String email, String password){
        boolean isValid = interactor.validatedCredentials(email, password);
        if (isValid) view.loginSuccess(); else view.loginFailed();
    }
}
