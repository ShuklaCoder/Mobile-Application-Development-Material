package com.jay.practical12;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.tvResult);
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tvResult = findViewById(R.id.tvResult);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_home) {
            tvResult.setText("Home Selected");
        }
        else if (id == R.id.menu_profile) {
            tvResult.setText("Profile Selected");
        }
        else if (id == R.id.menu_settings) {
            tvResult.setText("Settings Selected");
        }
        else if (id == R.id.menu_help) {
            tvResult.setText("Help Selected");
        }
        else if (id == R.id.menu_logout) {
            tvResult.setText("Logout Selected");
        }
        return true;
    }
}