package com.example.tutora.ui.mycourses;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tutora.CourseInfo;
import com.example.tutora.EnrolledCourseInfo;
import com.example.tutora.R;
import com.example.tutora.models.sampledata.Course;
import com.example.tutora.models.sampledata.CourseEnrolled;

import java.util.ArrayList;
import java.util.HashSet;

public class MyCourses extends Fragment {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView RV;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_my_courses, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RV = view.findViewById(R.id.listView_myCourses);
        layoutManager = new LinearLayoutManager(view.getContext());
        RV.setLayoutManager(layoutManager);


        ArrayList<EnrolledCourseInfo> list = new ArrayList<>();


        Course course = new Course(view.getContext());
        CourseEnrolled courseEnr = new CourseEnrolled(view.getContext());

        Cursor cur = course.getCategory("Programming");
        if (cur.moveToFirst()) {
            do {
                int n1 = cur.getInt(0);
                Cursor cur2 = courseEnr.get();
                if (cur2.moveToFirst()) {
                    do {
                        int n2 = cur2.getInt(1);
                        if (n1 == n2) {
                            list.add(new EnrolledCourseInfo(cur.getString(1), cur.getInt(6), cur.getInt(5)));
                        }
                    } while (cur2.moveToNext());
                }
            } while (cur.moveToNext());
        }

        adapter = new EnrolledCourseAdapter(list);
        RV.setAdapter(adapter);
    }
}