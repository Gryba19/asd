package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.MyDatabase;
import com.example.myapplication.R;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    MyDatabase database;
    TextView textView;
    Button addCar;
    Button clearAll;
    Button refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database= new MyDatabase(this, "cars",null,1);

        textView=findViewById(R.id.textView);
        addCar= findViewById(R.id.addCar);
        clearAll=findViewById(R.id.clearAll);
        refreshActivity();
        addCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        runOnUiThread(() -> MainActivity.this.refreshActivity());
                    }
                }, (long) 0.100);
               Intent intent = new Intent(MainActivity.this, MainActivity2.class);
              startActivity(intent);
                //database.registerCar("Ford", "Focus");
                refreshActivity();
            }
        });

        }

        public void removeAll(View view){
            database.deleteAll();
        }
        private void refreshActivity(){
            StringBuilder builder = new StringBuilder();
            Cursor cursor = database.getAllCars();
            while(cursor.moveToNext()) {
                builder.append("\nId:" + cursor.getInt(0));
                builder.append("\nNazwa:" + cursor.getString(1));
                builder.append("\nModel:" + cursor.getString(2));
                builder.append("\n---------------------");
            }
            textView.setText(builder.toString());
        }

    }
