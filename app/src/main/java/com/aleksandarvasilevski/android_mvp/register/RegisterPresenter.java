package com.aleksandarvasilevski.android_mvp.register;


public class RegisterPresenter {

    private IRegisterView view;
    public static boolean isRegistered = false;
    private RegisterInteractor registerInteractor = new RegisterInteractor();

    public RegisterPresenter(IRegisterView registerView){
        this.view = registerView;
    }

    public void attemptRegister(String email, String password, String firstname, String lastname){
        registerInteractor.attemptRegister(email, password, firstname, lastname);
    }
}
