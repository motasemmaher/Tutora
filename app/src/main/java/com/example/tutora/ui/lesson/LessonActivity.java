package com.example.tutora.ui.lesson;
import com.example.tutora.search;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.tutora.MainActivity;
import com.example.tutora.R;
import com.example.tutora.ui.course.cou;

public class LessonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        ImageView back =findViewById(R.id.backAc);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), cou.class);
                startActivity(intent);
            }
        });
        final ImageView searc = findViewById(R.id.searchAc);
        searc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater factory = getLayoutInflater();
                View regisText = factory.inflate(R.layout.header, (ViewGroup) findViewById(R.id.per));
                EditText user = (EditText) regisText.findViewById(R.id.textsearch);
                String sear = user.getText().toString();
                Intent intent = new Intent(getApplicationContext(),search.class);
                intent.putExtra("key","Java");
                v.getContext().startActivity(intent);
            }
        });
    }
}
