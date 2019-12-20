package com.example.tutora.ui.watchlater;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
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

import com.example.tutora.EnrolledCourseInfo;
import com.example.tutora.MainActivity;
import com.example.tutora.R;
import com.example.tutora.models.sampledata.Course;
import com.example.tutora.models.sampledata.CourseEnrolled;
import com.example.tutora.models.sampledata.Lesson;
import com.example.tutora.models.sampledata.Login;
import com.example.tutora.models.sampledata.Student;
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
        RV = view.findViewById(R.id.listView_myCourses);
        layoutManager = new LinearLayoutManager(view.getContext());
        RV.setLayoutManager(layoutManager);
        btnLesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Lesson lesson = new Lesson(view.getContext());

                ArrayList<Lesson> list = new ArrayList<>();
               // adapter = new lessonadapter(list);
                RV.setAdapter(adapter);
            }

        });
        btnCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Course course = new Course(view.getContext());

                ArrayList<EnrolledCourseInfo> list = new ArrayList<>();
                adapter = new EnrolledCourseAdapter(list);
                RV.setAdapter(adapter);
            }


        });

    }
}