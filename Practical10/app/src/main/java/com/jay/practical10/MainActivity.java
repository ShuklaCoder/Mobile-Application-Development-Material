package com.jay.practical10;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    Button login;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.etLoginUser);
        password=findViewById(R.id.etLoginPass);
        login=findViewById(R.id.btnLogin);
        sp=getSharedPreferences("UserData",MODE_PRIVATE);
        login.setOnClickListener(v -> {
            String user=username.getText().toString();
            String pass=password.getText().toString();
            String savedUser=sp.getString("username","");
            String savedPass=sp.getString("password","");
            if(user.equals(savedUser) && pass.equals(savedPass))
            {
                Intent i=new Intent(this,WelcomeActivity.class);
                i.putExtra("username",user);
                startActivity(i);
            }
            else
            {
                Intent i=new Intent(this,SignUpActivity.class);
                startActivity(i);
            }
        });
    }
}