package com.example.tutora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.tutora.models.sampledata.Course;
import com.example.tutora.models.sampledata.Lesson;
import com.example.tutora.models.sampledata.database;

public class MainActivity extends AppCompatActivity {

    database data = new database(this);

    Course course = new Course(this);
    Lesson lesson = new Lesson(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //(String name, String category, int rate, String time, double price, int path)
        course.insert("C++","Programming",3,"35:01",100.00,R.drawable.cpp_logo);
        course.insert("Jave","Programming",4,"35:01",150.00,R.drawable.java_logo);

        // (String name, String link,String time,int courseId,String reference, String task, String path)
        lesson.insert("Introduction", "https://www.youtube.com/watch?v=SQHREey_Yuc&list=PLfVsf4Bjg79Cu5MYkyJ-u4SyQmMhFeC1C",
                "05:40", 1, "https://developerinsider.co/introduction-to-cpp-cpp-programming",
                null, R.drawable.cpp_logo);
        lesson.insert("Where CPP is Used, Why Learn C++", "https://www.youtube.com/watch?v=brqRL_t0RmM&list=PLfVsf4Bjg79Cu5MYkyJ-u4SyQmMhFeC1C&index=2",
                "08:33", 1, "https://www.tutorialspoint.com/cplusplus/cpp_overview.htm",
                null, R.drawable.cpp_logo);
        lesson.insert("How C++ Works", "https://www.youtube.com/watch?v=ZTu0kf-7h08&list=PLfVsf4Bjg79Cu5MYkyJ-u4SyQmMhFeC1C&index=3",
                "22:48", 1, "https://www.toptal.com/c-plus-plus/c-plus-plus-understanding-compilation",
                null, R.drawable.cpp_logo);

        lesson.insert("Introduction", "https://www.youtube.com/watch?v=r59xYe3Vyks&list=PLS1QulWo1RIbfTjQvTdj8Y6yyq4R7g-Al",
                "13:10", 2, "https://en.wikiversity.org/wiki/Introduction_to_Programming_in_Java/Introduction_to_Java",
                null, R.drawable.java_logo);
        lesson.insert("Variables and Types", "https://www.youtube.com/watch?v=4ekASokneGU&list=PLS1QulWo1RIbfTjQvTdj8Y6yyq4R7g-Al&index=4",
                "09:57", 2, "https://www.javatpoint.com/java-variables",
                "class Main {   \n" +
                        "   public static void main(String args[]) {      \n" +
                        "         int t;      \n" +
                        "         System.out.println(t); \n" +
                        "    }   \n" +
                        "}", R.drawable.java_logo);

        lesson.insert("Getting User Input", "https://www.youtube.com/watch?v=qgMH6jOOFOE&list=PLS1QulWo1RIbfTjQvTdj8Y6yyq4R7g-Al&index=5",
                "12:10", 2, null,
                null, R.drawable.java_logo);
    }
}
