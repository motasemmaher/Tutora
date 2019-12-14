package com.example.tutora.models.sampledata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CourseEnrolled extends database {
    public static final String DATABASE_NAME = "Tutor.db";

    public CourseEnrolled(Context context) {
        super(context);
    }


    public boolean insert(int courseId){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("courseId",courseId);
        contentValues.put("completedLesson",0);
        if(database.insert("CourseEnrolled",null,contentValues) != -1){
            return  true;
        }
        return  false;
    }

    public boolean delete(int id){
        SQLiteDatabase database = this.getWritableDatabase();
        if(database.delete("CourseEnrolled","id",new String[]{""+id}) != -1){
            return  true;
        }
        return false;
    }

    public Cursor get(){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor= database.rawQuery("select * from CourseEnrolled",null);
        cursor.moveToFirst();
        return cursor;
    }

    public boolean update(int courseId,int count){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("courseId",courseId);
        contentValues.put("completedLesson",count);
        if(database.update("CourseEnrolled",contentValues,"courseId",new String[]{""+courseId}) != -1){
            return  true;
        }
        return  false;
    }

}
