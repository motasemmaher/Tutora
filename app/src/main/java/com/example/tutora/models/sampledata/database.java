package com.example.tutora.models.sampledata;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class database extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "Tutor.db";
    public database(Context context) {
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Course(id integer primary key autoincrement,name text,time text,category text,price DECIMAL(7,3),image integer,rate integer)");
        db.execSQL("create table Lesson (id integer primary key autoincrement,name text,link text,courseId integer, time text, reference text,task text,image integer, foreign key (courseId) references Course(id) )");
        db.execSQL("create table CourseEnrolled (id integer primary key autoincrement, courseId integer,completedLesson inegter, foreign key (courseId) references Course(id))");
        db.execSQL("create table Student(username text primary key,email text,password text,image integer)");
        db.execSQL("create table Login(username text primary key)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
