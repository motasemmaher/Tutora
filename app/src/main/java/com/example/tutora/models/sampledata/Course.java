package com.example.tutora.models.sampledata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Course extends database {

    public Course(Context context) {
        super(context);
    }


    public boolean insert(String name, String category, int rate, String time, double price, int path){
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

    public Cursor get(String name){
        SQLiteDatabase database= this.getReadableDatabase();
        Cursor cursor = database.rawQuery("select * from Course where name = ?",new String[]{name});
        cursor.moveToFirst();
        return cursor;
    }

}
