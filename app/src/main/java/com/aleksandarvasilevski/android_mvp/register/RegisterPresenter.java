package com.aleksandarvasilevski.android_mvp.register;



public class RegisterPresenter {

    private IRegisterView view;

    public RegisterPresenter(IRegisterView registerView){
        this.view = registerView;
    }

    public void attemptRegister(String firstName, String lastName, String eMail, String password){
        //boolean isVaild = interactor.validatedCredentials(firstName, lastName, eMail, password);
        //if (isVaild)view.registerSuccess(); else view.registerFalied();
    }
}
