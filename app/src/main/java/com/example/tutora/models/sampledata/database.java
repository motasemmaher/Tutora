package com.example.tutora.models.sampledata;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.tutora.R;


public class database extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "Tutor.db";
    Context con;
    public database(Context context) {
        super(context,DATABASE_NAME,null,1);
        con = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("create table Course(id integer primary key autoincrement,description text,name text,time text,category text,price DECIMAL(7,3),image integer,rate integer)");
            db.execSQL("create table Lesson (id integer primary key autoincrement,name text,link text,courseId integer, time text, reference text,task text,image integer, foreign key (courseId) references Course(id) )");
            db.execSQL("create table CourseEnrolled (id integer primary key autoincrement, courseId integer,completedLesson inegter, foreign key (courseId) references Course(id))");
            db.execSQL("create table Student(username text primary key,email text,password text,image integer)");
            db.execSQL("create table Login(username text primary key)");
            ContentValues content= new ContentValues();
            Course course = new Course(con);
            Lesson lesson = new Lesson(con);

            Student courseEnrolled = new Student(con);
            CourseEnrolled c = new CourseEnrolled(con);
            //(String name, String category, int rate, String time, double price, int path)
            content.put("name","C++");
            content.put("time","35:01");
            content.put("category","Programming");
            content.put("description","The purpose of learning a programming language is to become a better programmer; that is, to become more effective at designing and implementing new systems and at maintaining old ones.");
            content.put("rate",3);
            content.put("price",100.00);
            content.put("image", R.drawable.cpp_logo);
            db.insert("Course",null,content);
            content = new ContentValues();
            content.put("name","Jave");
            content.put("time","35:01");
            content.put("category","Programming");
            content.put("description","The purpose of learning a programming language is to become a better programmer; that is, to become more effective at designing and implementing new systems and at maintaining old ones.");
            content.put("rate",4);
            content.put("price",150.00);
            content.put("image",R.drawable.java_logo);
            db.insert("Course",null,content);
            ContentValues contentValues = new ContentValues();
            contentValues.put("link","https://www.youtube.com/watch?v=SQHREey_Yuc&list=PLfVsf4Bjg79Cu5MYkyJ-u4SyQmMhFeC1C");
            contentValues.put("name","Introduction");
            contentValues.put("courseId",1);
            contentValues.put("reference","https://developerinsider.co/introduction-to-cpp-cpp-programming");
            contentValues.put("time","05:40");
            contentValues.put("image", R.drawable.cpp_logo);
            db.insert("Lesson",null,contentValues);

             contentValues = new ContentValues();
            contentValues.put("link","https://www.youtube.com/watch?v=brqRL_t0RmM&list=PLfVsf4Bjg79Cu5MYkyJ-u4SyQmMhFeC1C&index=2");
            contentValues.put("name","Where CPP is Used, Why Learn C++");
            contentValues.put("courseId",1);
            contentValues.put("reference", "https://www.tutorialspoint.com/cplusplus/cpp_overview.htm");
            contentValues.put("time","08:33");
            contentValues.put("image", R.drawable.cpp_logo);
            db.insert("Lesson",null,contentValues);

            contentValues = new ContentValues();
            contentValues.put("link","https://www.youtube.com/watch?v=ZTu0kf-7h08&list=PLfVsf4Bjg79Cu5MYkyJ-u4SyQmMhFeC1C&index=3");
            contentValues.put("name","How C++ Works");
            contentValues.put("courseId",1);
            contentValues.put("reference", "https://www.toptal.com/c-plus-plus/c-plus-plus-understanding-compilation");
            contentValues.put("time","22:48");
            contentValues.put("image", R.drawable.cpp_logo);
            db.insert("Lesson",null,contentValues);

            contentValues = new ContentValues();
            contentValues.put("link","https://www.youtube.com/watch?v=r59xYe3Vyks&list=PLS1QulWo1RIbfTjQvTdj8Y6yyq4R7g-Al");
            contentValues.put("name","Introduction");
            contentValues.put("courseId",2);
            contentValues.put("reference",  "https://en.wikiversity.org/wiki/Introduction_to_Programming_in_Java/Introduction_to_Java");
            contentValues.put("time","13:10");
            contentValues.put("image", R.drawable.java_logo);
            db.insert("Lesson",null,contentValues);

            contentValues = new ContentValues();
            contentValues.put("link", "https://www.youtube.com/watch?v=4ekASokneGU&list=PLS1QulWo1RIbfTjQvTdj8Y6yyq4R7g-Al&index=4");
            contentValues.put("name","Variables and Types");
            contentValues.put("courseId",2);
            contentValues.put("reference",  "https://www.javatpoint.com/java-variables");
            contentValues.put("time","09:57");
            contentValues.put("task","class Main {   \n" +
                            "   public static void main(String args[]) {      \n" +
                            "         int t;      \n" +
                            "         System.out.println(t); \n" +
                            "    }   \n" +
                            "}");

            contentValues.put("image", R.drawable.java_logo);

            db.insert("Lesson",null,contentValues);

            contentValues = new ContentValues();
            contentValues.put("link", "https://www.youtube.com/watch?v=qgMH6jOOFOE&list=PLS1QulWo1RIbfTjQvTdj8Y6yyq4R7g-Al&index=5");
            contentValues.put("name","Getting User Input");
            contentValues.put("courseId",2);
            contentValues.put("reference",  "https://www.javatpoint.com/java-variables");
            contentValues.put("time","12:10");

            contentValues.put("image", R.drawable.java_logo);

            db.insert("Lesson",null,contentValues);
             contentValues = new ContentValues();
            contentValues.put("courseId",1);
            contentValues.put("completedLesson",0);
            db.insert("CourseEnrolled",null,contentValues);

        }finally {

        }


    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
