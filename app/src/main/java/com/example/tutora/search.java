package com.example.tutora;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.tutora.models.sampledata.Course;
import com.example.tutora.ui.course.cou;
import com.example.tutora.ui.mycourses.EnrolledCourseAdapter;

import java.util.ArrayList;

public class search extends AppCompatActivity {
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView RV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Intent intent = getIntent();
        String search = intent.getStringExtra("key");
        Course course = new Course(getApplicationContext());
        ArrayList<EnrolledCourseInfo> list = new ArrayList<>();
        RV = findViewById(R.id.Rv);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        RV.setLayoutManager(layoutManager);
        Cursor cur = course.get(search);
        if (cur.moveToFirst()) {
            do {
                list.add(new EnrolledCourseInfo(cur.getString(2), cur.getInt(6), cur.getInt(6)));
            } while (cur.moveToNext());
        }
        adapter = new EnrolledCourseAdapter(list);
        RV.setAdapter(adapter);
        ImageView back =findViewById(R.id.backAc);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), cou.class);
                startActivity(intent);
            }
        });
    }
}
