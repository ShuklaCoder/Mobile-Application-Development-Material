package com.jay.practical13;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button btnUpper;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        btnUpper = findViewById(R.id.btnUpper);
        textView = findViewById(R.id.textView);
        btnUpper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                textView.setText(text.toUpperCase());
            }
        });
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                String text = editText.getText().toString();
                textView.setText(text.toUpperCase());
                return false;
            }
        });
    }
}