package com.example.tutora.ui.course;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tutora.R;
import com.example.tutora.ui.lesson.LessonActivity;

import java.util.ArrayList;

public class lessonadapter extends RecyclerView.Adapter<lessonadapter.lessonView>{

    private ArrayList<Lesson> data;

    public lessonadapter(ArrayList<Lesson> arr) {
        data = arr;
    }
    @NonNull
    @Override
    public lessonView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new lessonView(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_lesson,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull lessonView holder, int position) {
        holder.image.setImageResource(data.get(position).idImge);
        holder.name.setText(data.get(position).name);
        holder.time.setText(data.get(position).time);
        if(data.get(position).seen){
            holder.seen.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public static class lessonView extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;
        TextView time;
        ImageView seen;
        public lessonView(final View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.lessonCardImg);
            name = (TextView) itemView.findViewById(R.id.lessonNameTV);
            time = (TextView) itemView.findViewById(R.id.estimatedLessonTimeTV);
            seen = (ImageView) itemView.findViewById(R.id.lessonCompleteCheck);

            itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent int1 = new Intent(itemView.getContext(), LessonActivity.class);
                    itemView.getContext().startActivity(int1);
                }
            });
        }

    }
}
