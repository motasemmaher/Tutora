package com.example.tutora.models.sampledata;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Login extends database {
    public static final String DATABASE_NAME = "Tutor.db";

    public Login(Context context) {
        super(context);
    }




    public boolean insertI(String username){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put("username",username);
        if(database.insert("Login",null,contentValues) != -1){
            return  true;
        }
        return false;
    }

    public boolean delete(int id){
        SQLiteDatabase database = this.getWritableDatabase();
        if(database.delete("Login","id",new String[]{""+id}) != -1){
            return  true;
        }

        return false;
    }
}
