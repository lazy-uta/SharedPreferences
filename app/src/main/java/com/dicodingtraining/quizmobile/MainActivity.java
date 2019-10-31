package com.dicodingtraining.quizmobile;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.dicodingtraining.quizmobile.Helper.SharedPrefManager;

public class MainActivity extends AppCompatActivity {

    SharedPrefManager sp;
    TextView username, password;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (TextView) findViewById(R.id.txtnama);
        password = (TextView) findViewById(R.id.txtdev);
        btnLogin = (Button) findViewById(R.id.btn_login);

        sp = new SharedPrefManager(this);
        //username.setText(sp.getKeyNama());
       password.setText(sp.getSpDevelop());
    }
}
