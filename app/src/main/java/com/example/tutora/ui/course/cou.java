package com.example.tutora.ui.course;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tutora.MainActivity;
import com.example.tutora.R;
import com.example.tutora.search;

import java.util.ArrayList;

public class cou extends AppCompatActivity {
//    int id=0;
//   public  cou(int id){
//       this.id = id;
//   }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cou);
        RecyclerView re = findViewById(R.id.re);
        // Lesson lesson = new Lesson(view.getContext());
        ImageView back =findViewById(R.id.backAc);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        RecyclerView.LayoutManager layoutManager;
        layoutManager = new LinearLayoutManager(getApplicationContext());
        re.setLayoutManager(layoutManager);


        com.example.tutora.models.sampledata.Lesson lesson = new com.example.tutora.models.sampledata.Lesson(getApplicationContext());

        Cursor cursor = lesson.getLessons(1);
        ArrayList<Lesson> lessons = new ArrayList<>();
        if(cursor.moveToFirst()){
            boolean flag = true;
            do{
                if(flag){
                    flag = !flag;
                    lessons.add(new com.example.tutora.ui.course.Lesson(cursor.getString(1),cursor.getString(4),cursor.getInt(7),true));
                }else {
                    lessons.add(new com.example.tutora.ui.course.Lesson(cursor.getString(1),cursor.getString(4),cursor.getInt(7),false));
                }
            } while (cursor.moveToNext());
        }

        lessonadapter v= new lessonadapter(lessons);
        re.setAdapter(v);
        final ImageView searc = findViewById(R.id.searchAc);
        searc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater factory = getLayoutInflater();
                View regisText = factory.inflate(R.layout.header,(ViewGroup) findViewById(R.id.per));
                EditText user = (EditText) regisText.findViewById(R.id.textsearch);
                String sear = user.getText().toString();
                Intent intent = new Intent(getApplicationContext(), search.class);
                intent.putExtra("key","Java");
                v.getContext().startActivity(intent);
            }
        });
    }
}
