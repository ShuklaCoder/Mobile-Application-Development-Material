package com.jay.practical11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText etUsername, etPassword;
    Button btnLogin;
    String correctUser = "admin";
    String correctPass = "1234";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = etUsername.getText().toString();
                String pass = etPassword.getText().toString();
                if(user.equals(correctUser) && pass.equals(correctPass))
                {
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    intent.putExtra("username", user);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Invalid Login",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}