package com.example.tutora.ui.course;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tutora.R;

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
        return 0;
    }
    public static class lessonView extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;
        TextView time;
        ImageView seen;
        public lessonView(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.lessonCardImg);
            name = itemView.findViewById(R.id.lessonNameTV);
            time = itemView.findViewById(R.id.estimatedLessonTimeTV);
            seen = itemView.findViewById(R.id.lessonCompleteCheck);
        }
    }
}
