package com.aleksandarvasilevski.android_mvp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aleksandarvasilevski.android_mvp.R;
import com.aleksandarvasilevski.android_mvp.register.IRegisterView;
import com.aleksandarvasilevski.android_mvp.register.RegisterPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity implements IRegisterView {

    RegisterPresenter presenter;

    //Binding the views with ButterKnife library to eliminate the findViewById calls.
    @BindView(R.id.et_register_firstname) EditText firstNameEt;
    @BindView(R.id.et_register_lastname) EditText lastNameEt;
    @BindView(R.id.et_register_email) EditText emailEt;
    @BindView(R.id.et_register_password) EditText passwordEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        //Presenter reference to the view.
        presenter = new RegisterPresenter(this);
    }

    @OnClick(R.id.bt_register_submit)
    void registerSubmit(){
        String firstName = firstNameEt.getText().toString();
        String lastName = lastNameEt.getText().toString();
        String email = emailEt.getText().toString();
        String password = passwordEt.getText().toString();
        presenter.attemptRegister(firstName, lastName, email, password);
    }

    @Override
    public void registerSuccess() {
        Toast.makeText(this, "Register Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void registerFalied() {
        Toast.makeText(this, "Register Failed", Toast.LENGTH_SHORT).show();
    }
}
