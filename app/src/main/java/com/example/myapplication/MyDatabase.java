package com.example.myapplication;

import androidx.annotation.Nullable;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabase extends SQLiteOpenHelper {

   public MyDatabase(@Nullable Context context, @Nullable String name,@Nullable SQLiteDatabase.CursorFactory factory,int version)
   {
      super(context, "cars.db",null,1);
   }

   @Override
   public void onCreate(SQLiteDatabase db) {
      db.execSQL("create table cars(id integer primary key autoincrement,"
      +"name text,"
              +"model text);"
      );
   }


   @Override
   public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

   }
   public void registerCar(String name, String model)
   {
      SQLiteDatabase db= getWritableDatabase();
      ContentValues values = new ContentValues();
      values.put("name",name);
      values.put("model",model);
      db.insertOrThrow("cars",null,values);
   }
   public Cursor getAllCars(){
      String[] columns ={"id","name","model"};
      SQLiteDatabase db = getReadableDatabase();
      return db.query("cars",columns,null,null,null,null,null);
   }
   public void deleteAll(){
      SQLiteDatabase db = getWritableDatabase();
      db.delete("cars",null,null);
   }
   public Cursor getCar(int id){
      SQLiteDatabase db = getReadableDatabase();
      String[] columns={"id","name","model"};
      return db.query("cars", columns, "id=", new String[] {String.valueOf(id)}, null ,null, null);
   }
   public int deleteCar(String id){
      SQLiteDatabase db = getWritableDatabase();
      String[] columns={"id","name","model"};
      return db.delete("cars", "id="+id, null);
   }
}