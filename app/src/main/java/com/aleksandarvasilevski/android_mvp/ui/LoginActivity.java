package com.aleksandarvasilevski.android_mvp.ui;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.aleksandarvasilevski.android_mvp.R;
import com.aleksandarvasilevski.android_mvp.login.ILoginView;
import com.aleksandarvasilevski.android_mvp.login.LoginPresenter;
import com.aleksandarvasilevski.android_mvp.network.ILoginApiClient;
import com.aleksandarvasilevski.android_mvp.network.LoginApiClient;
import com.aleksandarvasilevski.android_mvp.network.model.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    LoginPresenter presenter;

    //Binding the views with ButterKnife library to eliminate the findViewById calls.
    @BindView(R.id.et_login_email) EditText emailEt;
    @BindView(R.id.et_login_password) EditText passwordEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        //Presenter reference to the view.
        presenter = new LoginPresenter(this);
    }

    @OnClick(R.id.bt_login)
    void login(){
        String email = emailEt.getText().toString();
        String password = passwordEt.getText().toString();
        presenter.attemptLogin(email, password);
        if (LoginPresenter.isConected) {
            Intent openMain = new Intent(this, MainActivity.class);
            startActivity(openMain);
        }
    }

    @OnClick(R.id.bt_register)
    void register(){
        Intent openRegister = new Intent(this, RegisterActivity.class);
        startActivity(openRegister);
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailed() {
        Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
    }
}
