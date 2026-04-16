package com.jay.practical8;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    TextView tvTIC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroupCourses);
        tvTIC = findViewById(R.id.tvTIC);

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == R.id.rbBTECH) {
                tvTIC.setText("TIC: 120 Credits");
            }
            else if (checkedId == R.id.rbBBA) {
                tvTIC.setText("TIC: 110 Credits");
            }
            else if (checkedId == R.id.rbBCom) {
                tvTIC.setText("TIC: 100 Credits");
            }
        });
    }
}