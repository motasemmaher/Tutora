package com.example.tutora.ui.mycourses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tutora.CourseInfo;
import com.example.tutora.R;

import java.util.ArrayList;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder>{
    private ArrayList<CourseInfo> data;

    public CourseAdapter(ArrayList<CourseInfo> arr) {
        data = arr;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_course, parent, false);
        return new CourseViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        holder.title.setText(data.get(position).title);
        holder.price.setText(data.get(position).price + "$");
        int rating = data.get(position).rating;
        if (rating >= 1) {
            holder.star1.setImageResource(R.drawable.star_colored);
        }
        if (rating >= 2) {
            holder.star2.setImageResource(R.drawable.star_colored);
        }
        if (rating >= 3) {
            holder.star3.setImageResource(R.drawable.star_colored);
        }
        if (rating >= 4) {
            holder.star4.setImageResource(R.drawable.star_colored);
        }
        if (rating >= 5) {
            holder.star5.setImageResource(R.drawable.star_colored);
        }
        holder.image.setImageResource(data.get(position).img);
        //holder.
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class CourseViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView price;
        ImageView star1;
        ImageView star2;
        ImageView star3;
        ImageView star4;
        ImageView star5;
        ImageView image;
        public CourseViewHolder(View itemView) {
            super(itemView);
            this.title = (TextView) itemView.findViewById(R.id.titleTV);
            this.price = (TextView) itemView.findViewById(R.id.priceTV);
            this.star1 = (ImageView) itemView.findViewById(R.id.star1);
            this.star2 = (ImageView) itemView.findViewById(R.id.star2);
            this.star3 = (ImageView) itemView.findViewById(R.id.star3);
            this.star4 = (ImageView) itemView.findViewById(R.id.star4);
            this.star5 = (ImageView) itemView.findViewById(R.id.star5);
            this.image = (ImageView) itemView.findViewById(R.id.courseImage);
        }
    }
}
