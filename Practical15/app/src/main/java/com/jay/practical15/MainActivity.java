package com.jay.practical15;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etId, etName;
    Button btnInsert, btnView, btnUpdate, btnDelete;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etId = findViewById(R.id.etId);
        etName = findViewById(R.id.etName);
        btnInsert = findViewById(R.id.btnInsert);
        btnView = findViewById(R.id.btnView);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        db = new DBHelper(this);
        btnInsert.setOnClickListener(v -> {
            int id = Integer.parseInt(etId.getText().toString());
            String name = etName.getText().toString();
            if(db.insertData(id, name))
                Toast.makeText(this,"Inserted",Toast.LENGTH_SHORT).show();
        });
        btnView.setOnClickListener(v -> {
            Cursor c = db.getData();
            String data = "";
            while(c.moveToNext()) {
                data += "ID: "+c.getString(0)+" Name: "+c.getString(1)+"\n";
            }
            Toast.makeText(this,data,Toast.LENGTH_LONG).show();
        });
        btnUpdate.setOnClickListener(v -> {
            int id = Integer.parseInt(etId.getText().toString());
            String name = etName.getText().toString();
            db.updateData(id,name);
            Toast.makeText(this,"Updated",Toast.LENGTH_SHORT).show();
        });
        btnDelete.setOnClickListener(v -> {
            int id = Integer.parseInt(etId.getText().toString());
            db.deleteData(id);
            Toast.makeText(this,"Deleted",Toast.LENGTH_SHORT).show();
        });
    }
}