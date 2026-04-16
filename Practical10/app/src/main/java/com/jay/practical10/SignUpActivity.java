package com.jay.practical10;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        TextView loginLink;

        loginLink=findViewById(R.id.tvLogin);

        loginLink.setOnClickListener(v -> {
            startActivity(new Intent(SignUpActivity.this, WelcomeActivity.class));
        });
    }
}