package com.example.tutora.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Lesson  extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Tutor.db";

    public Lesson(Context context) {
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Lesson (id integer primary key autoincrement,link text,courseId integer, time text, reference text,task text,image text, foreign key (courseId) references Course(id) )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean insert(String link,String time,int courseId,String reference, String task, String path){
        SQLiteDatabase database= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("link",link);
        contentValues.put("courseId",courseId);
        contentValues.put("reference",reference);
        contentValues.put("time",time);
        contentValues.put("task",task);
        contentValues.put("path",path);

        if(database.insert("Lesson",null,contentValues) != -1){
            database.close();
            return true;
        }
        return  false;
    }

    public Cursor getLessons(int id){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("select * from Lesson where id = ?",new String[]{""+id});
        cursor.moveToFirst();
        return cursor;
    }

}
