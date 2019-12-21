package com.example.tutora.models.sampledata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class CourseEnrolled extends database {

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

        database.execSQL("delete from CourseEnrolled where courseId = "+id);
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
