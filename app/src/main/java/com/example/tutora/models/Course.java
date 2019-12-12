package com.example.tutora.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Course extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Tutor.db";

    public Course(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Course(id integer primary key autoincrement,name text,time text,category text,price DECIMAL(7,3),image text,rate text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insert(String name,String category,String rate,String time,float price,String path){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("name",name);
        content.put("time",time);
        content.put("category",category);
        content.put("rate",rate);
        content.put("price",price);
        content.put("image",path);
        if(database.insert("Course",null,content) != -1){
            database.close();
            return true;
        }
        return  false;
    }

    public Cursor getCategory(String category){
        SQLiteDatabase database= this.getReadableDatabase();
        Cursor cursor = database.rawQuery("select * from Course where category = ?",new String[]{category});
        cursor.moveToFirst();
        return cursor;
    }

}
