package com.example.tutora.ui.category;

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
import com.example.tutora.R;
import com.example.tutora.models.sampledata.Course;
import com.example.tutora.ui.mycourses.CourseAdapter;

import java.util.ArrayList;

public class Category extends Fragment {

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView RV;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RV = view.findViewById(R.id.coursesRV);
        layoutManager = new LinearLayoutManager(view.getContext());
        RV.setLayoutManager(layoutManager);


        ArrayList<CourseInfo> list = new ArrayList<>();
        Course course = new Course(view.getContext());
        Cursor cur = course.getCategory("Programming");
        if (cur.moveToFirst()) {
            do {
                CourseInfo ci = new CourseInfo(cur.getString(1), (float)cur.getDouble(4), cur.getInt(6), cur.getInt(5));
                list.add(ci);
            } while (cur.moveToNext());
        }

        adapter = new CourseAdapter(list);
        RV.setAdapter(adapter);
    }
}