package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    MyDatabase database;
    EditText name;
    EditText model;
    Button wyslij;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        wyslij=findViewById(R.id.submit);
        name=findViewById(R.id.name);
        model=findViewById(R.id.model);
        database= new MyDatabase(this, "cars",null,1);
        wyslij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name= String.valueOf(name.getText().toString());
                String Model=String.valueOf(model.getText().toString());
                database.registerCar(String.valueOf(Name), String.valueOf(Model));
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}