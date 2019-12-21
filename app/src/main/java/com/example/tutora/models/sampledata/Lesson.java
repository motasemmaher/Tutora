package com.example.tutora.models.sampledata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Lesson  extends database {

    public Lesson(Context context) {
        super(context);
    }

    public boolean insert(String name, String link,String time,int courseId,String reference, String task, int path){
        SQLiteDatabase database= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("link",link);
        contentValues.put("name",name);
        contentValues.put("courseId",courseId);
        contentValues.put("reference",reference);
        contentValues.put("time",time);
        contentValues.put("task",task);
        contentValues.put("image",path);

        if(database.insert("Lesson",null,contentValues) != -1){
            database.close();
            return true;
        }
        return  false;
    }

    public Cursor getLessons(int id){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("select * from Lesson where courseId = ?",new String[]{""+id});
        cursor.moveToFirst();
        return cursor;
    }

}
