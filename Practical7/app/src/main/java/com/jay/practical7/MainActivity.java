package com.jay.practical7;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText editText = findViewById(R.id.edittext);
        RadioGroup radioGroup = findViewById(R.id.idRadioGroup);
        TextView textView = findViewById(R.id.result);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String input = editText.getText().toString();

                if (input.isEmpty()) {
                    textView.setText("Please enter an amount");
                    return;
                }

                double original = Double.parseDouble(input);
                double finalAmount = 0;

                if (checkedId == R.id.ten_percent) {
                    finalAmount = calculateDiscount(original, 10);
                } else if (checkedId == R.id.fifthteen_percent) {
                    finalAmount = calculateDiscount(original, 15);
                } else if (checkedId == R.id.twenty_percent) {
                    finalAmount = calculateDiscount(original, 20);
                }

                textView.setText("Final Amount: " + String.format("%.2f", finalAmount));
            }
        });
    }

    public double calculateDiscount(Double original,int discount)
    {
        double discounted_value = original * (discount/100.0);
        return (original - discounted_value);
    }
}