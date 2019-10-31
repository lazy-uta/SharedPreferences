package com.dicodingtraining.quizmobile;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dicodingtraining.quizmobile.Helper.SharedPrefManager;


public class LoginActivity extends AppCompatActivity {

    SharedPrefManager sp;
    private final String KEY_NAME = "key_name";

    EditText username, password;
    Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.edt_username);
        password = (EditText) findViewById(R.id.edt_password);
        btnLogin = (Button) findViewById(R.id.btn_login);

        sp = new SharedPrefManager(this);

        ceklogin();



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String usernameKey = username.getText().toString();
                String passwordKey = password.getText().toString();

                if (usernameKey.equals("admin") && passwordKey.equals("admin123")) {
                    sp.saveSPString(SharedPrefManager.SP_NAMA, usernameKey);
                    sp.saveSPString(SharedPrefManager.SP_PASSWD, passwordKey);
                    sp.saveSPBolean(SharedPrefManager.SP_SUDAH_LOGIN, true);
                    Toast.makeText(getApplicationContext(), "LOGIN SUKSES",
                            Toast.LENGTH_SHORT).show();


                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    LoginActivity.this.startActivity(intent);
                    finish();
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setMessage("Username atau Password Anda salah!")
                            .setNegativeButton("Retry", null).create().show();
                }
            }

        });


    }


    private void ceklogin() {
        if (sp.Login()){
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
    }
}}
