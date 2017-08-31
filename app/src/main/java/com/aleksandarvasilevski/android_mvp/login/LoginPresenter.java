package com.aleksandarvasilevski.android_mvp.login;



public class LoginPresenter implements ILoginPresenter {

    private ILoginView view;
    private SynchronousLoginInteractor interactor;

    public LoginPresenter(ILoginView ILoginView) {
        this.view = ILoginView;
        this.interactor = new SynchronousLoginInteractor();
    }

    public void attemptLogin(String email, String password){
        boolean isValid = interactor.validatedCredentials(email, password);
        if (isValid) view.loginSuccess(); else view.loginFailed();
    }
}
