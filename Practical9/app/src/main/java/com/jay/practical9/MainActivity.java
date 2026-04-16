package com.jay.practical9;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox monitor, keyboard, printer, mouse;
    TextView result;
    Button show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        monitor = findViewById(R.id.cbMonitor);
        keyboard = findViewById(R.id.cbKeyboard);
        printer = findViewById(R.id.cbPrinter);
        mouse = findViewById(R.id.cbMouse);
        result = findViewById(R.id.tvResult);
        show = findViewById(R.id.btnShow);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selected = "Selected Items:\n";
                if(monitor.isChecked())
                    selected += "Monitor\n";
                if(keyboard.isChecked())
                    selected += "Keyboard\n";
                if(printer.isChecked())
                    selected += "Printer\n";
                if(mouse.isChecked())
                    selected += "Mouse\n";
                result.setText(selected);
            }
        });
    }
}