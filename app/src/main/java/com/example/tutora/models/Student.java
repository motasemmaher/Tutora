package com.example.tutora.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Student extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Tutor.db";

    public Student(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Student(username text primary key,email text,password text,image text,courseEnrolledId integer,courseWatchLaterId integer,lessonWatachLater integer," +
                "foreign key (courseEnrolledId) references CourseEnrolled(id)," +
                "foreign key (courseWatchLaterId) references Course(id)," +
                "foreign key (lessonWatachLater) references Lesson(id) )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insert(String username,String email,String password,String path){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues =  new ContentValues();
        contentValues.put("username",username);
        contentValues.put("email",email);
        contentValues.put("password",password);
        contentValues.put("path",path);
        if (database.insert("Student",null,contentValues) != -1){
            return true;
        }
        return  false;
    }

    public Cursor getStudent(String username){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("select * from Student where username = ?", new String[]{username});
        cursor.moveToFirst();
        return cursor;
    }

    public boolean isExist(String username,String password){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("select username,password from Student where userame=? and password = ?",new String[]{username,password});
        if(cursor.getCount() == 1){
            return  true;
        }
        return  false;
    }
}
