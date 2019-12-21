package com.example.tutora.ui.category;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
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
                Log.i("info", cur.getString(1) + "--" + cur.getString(2) + "--" + cur.getString(3) + "--"
                        + cur.getString(4) + "--" + cur.getString(5) + "--" + cur.getString(6) + "--");
                CourseInfo ci = new CourseInfo(cur.getString(2), (float)cur.getDouble(5), cur.getInt(5), cur.getInt(6));
                list.add(ci);
            } while (cur.moveToNext());
        }

        adapter = new CourseAdapter(list);
        RV.setAdapter(adapter);
    }
}