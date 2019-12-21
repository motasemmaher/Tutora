package com.example.tutora.ui.watchlater;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tutora.CourseInfo;
import com.example.tutora.EnrolledCourseInfo;
import com.example.tutora.MainActivity;
import com.example.tutora.R;
import com.example.tutora.models.sampledata.Course;
import com.example.tutora.models.sampledata.CourseEnrolled;
import com.example.tutora.models.sampledata.Lesson;
import com.example.tutora.models.sampledata.Login;
import com.example.tutora.models.sampledata.Student;
import com.example.tutora.ui.category.CourseAdapter;
import com.example.tutora.ui.course.lessonadapter;
import com.example.tutora.ui.mycourses.EnrolledCourseAdapter;

import java.util.ArrayList;

public class WatchLater extends Fragment {


    Button btnCourse ,btnLesson ;
    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView RV;

    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState)
    // public void onCreate(Bundle savedInstanceState)
    {


        return inflater.inflate(R.layout.fragment_watch_later, container, false);


    }
    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnCourse = view.findViewById(R.id.CourseButton);
        btnLesson = view.findViewById(R.id.LessonButton);
        RV = view.findViewById(R.id.zxc);
        layoutManager = new LinearLayoutManager(view.getContext());
        RV.setLayoutManager(layoutManager);


        btnLesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<com.example.tutora.ui.course.Lesson> list2 = new ArrayList<>();

                Lesson lesson = new Lesson(view.getContext());
                Cursor cursor = lesson.getLessons(2);
                if(cursor.moveToFirst()){
                    boolean flag = true;
                    do{
                        if(flag){
                            flag = !flag;
                            list2.add(new com.example.tutora.ui.course.Lesson(cursor.getString(1),cursor.getString(4),cursor.getInt(7),true));
                        }else {
                            list2.add(new com.example.tutora.ui.course.Lesson(cursor.getString(1),cursor.getString(4),cursor.getInt(7),false));
                        }
                    } while (cursor.moveToNext());
                }

                lessonadapter adapter= new lessonadapter(list2);
                RV.setAdapter(adapter);
               // adapter = new lessonadapter(list);
            }

        });
        btnCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<CourseInfo> list = new ArrayList<>();
                Course course = new Course(view.getContext());
                Cursor cur = course.getCategory("Programming");
                if (cur.moveToFirst()) {
                    do {
                        Log.i("info", cur.getString(1) + "--" + cur.getString(2) + "--" + cur.getString(3) + "--"
                                + cur.getString(4) + "--" + cur.getString(5) + "--" + cur.getString(6) + "--");
                        CourseInfo ci = new CourseInfo(cur.getString(2), (float)cur.getDouble(5), cur.getInt(5), cur.getInt(6));
                        list.add(ci);
                    } while (cur.moveToNext());
                }
                adapter = new CourseAdapter(list);
                RV.setAdapter(adapter);
            }


        });

    }
}