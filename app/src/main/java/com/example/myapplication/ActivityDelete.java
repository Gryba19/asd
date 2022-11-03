package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityDelete extends AppCompatActivity {
    MyDatabase database;
    EditText podaj;
    Button usun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        podaj=findViewById(R.id.podajId);
        usun=findViewById(R.id.delete);
        database= new MyDatabase(this, "cars",null,1);
        usun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}