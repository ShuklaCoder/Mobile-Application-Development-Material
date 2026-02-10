package com.jay.practical5;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView display;
    double firstNumber = 0;
    double secondNumber = 0;
    char operator = ' ';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.display_total);
        int[] numberIds = {
                R.id.zero, R.id.one, R.id.two, R.id.three,
                R.id.four, R.id.five, R.id.six,
                R.id.seven, R.id.eight, R.id.nine};
        View.OnClickListener numberClickListener = v -> {
            Button button = (Button) v;
            display.append(button.getText().toString());
        };
        for (int id : numberIds) {
            findViewById(id).setOnClickListener(numberClickListener);
        }
        findViewById(R.id.sum).setOnClickListener(v -> setOperator('+'));
        findViewById(R.id.minus).setOnClickListener(v -> setOperator('-'));
        findViewById(R.id.multiply).setOnClickListener(v -> setOperator('*'));
        findViewById(R.id.divide).setOnClickListener(v -> setOperator('/'));
        findViewById(R.id.total).setOnClickListener(v -> calculate());
        findViewById(R.id.clear).setOnClickListener(v -> {
            display.setText("0");
            firstNumber = 0;
            secondNumber = 0;
            operator = ' ';
        });
    }
    private void setOperator(char op) {
        firstNumber = Double.parseDouble(display.getText().toString());
        operator = op;
        display.setText("");
    }
    private void calculate() {
        secondNumber = Double.parseDouble(display.getText().toString());
        double result = 0;
        switch (operator) {
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber;
                break;
            case '/':
                if (secondNumber != 0)
                    result = firstNumber / secondNumber;
                else {
                    display.setText("Error");
                    return;
                }
                break;
        }
        display.setText(String.valueOf(result));
    }
}
