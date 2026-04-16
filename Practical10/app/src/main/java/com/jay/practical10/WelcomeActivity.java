package com.jay.practical10;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {
    TextView welcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        welcome=findViewById(R.id.tvWelcome);
        String username=getIntent().getStringExtra("username");
        welcome.setText("Welcome " + username);
    }
}