package com.example.tutora.ui.mycourses;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import com.example.tutora.EnrolledCourseInfo;
import com.example.tutora.R;
import com.example.tutora.models.sampledata.CourseEnrolled;
import com.example.tutora.ui.course.cou;
//import com.example.tutora.ui.course.course;
import com.example.tutora.models.sampledata.Lesson;
import com.example.tutora.ui.lesson.LessonActivity;

import java.util.ArrayList;

public class EnrolledCourseAdapter extends RecyclerView.Adapter<EnrolledCourseAdapter.CourseViewHolder>{
    private ArrayList<EnrolledCourseInfo> data;
    static int po;
    public EnrolledCourseAdapter(ArrayList<EnrolledCourseInfo> arr) {
        data = arr;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_course_enrolled, parent, false);
        return new CourseViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final CourseViewHolder holder, final int position) {
        holder.title.setText(data.get(position).title);
        po = position;
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
        holder.progress.setProgress(data.get(position).progress);

        //holder.trash.setOnClickListener();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class CourseViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView star1;
        ImageView star2;
        ImageView star3;
        ImageView star4;
        ImageView star5;
        ImageView image;
        ProgressBar progress;
        ImageButton trash;
        public CourseViewHolder(final View itemView) {
            super(itemView);
            this.title = (TextView) itemView.findViewById(R.id.titleTV);
            this.star1 = (ImageView) itemView.findViewById(R.id.star1);
            this.star2 = (ImageView) itemView.findViewById(R.id.star2);
            this.star3 = (ImageView) itemView.findViewById(R.id.star3);
            this.star4 = (ImageView) itemView.findViewById(R.id.star4);
            this.star5 = (ImageView) itemView.findViewById(R.id.star5);
            this.image = (ImageView) itemView.findViewById(R.id.courseImage);
            this.progress = (ProgressBar) itemView.findViewById(R.id.progressBar);
            this.trash = (ImageButton) itemView.findViewById(R.id.imageButton3);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                 //   cou co = new cou(po);
                    Intent intent = new Intent(itemView.getContext(),cou.class);
                    itemView.getContext().startActivity(intent);
                //    ((FragmentActivity) v.getContext()).getSupportFragmentManager().beginTransaction().add(R.id.nav_host_fragment,new course(po)).commit();
                }
            });
            trash.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(v.getContext());
                    alert.setTitle("Course Deletion");
                    alert.setMessage("Are you sure you want to remove this course?");
                    alert.setPositiveButton("Yes", new AlertDialog.OnClickListener(){

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            CourseEnrolled courseEnrolled = new CourseEnrolled(itemView.getContext());
                            courseEnrolled.delete(1);
                                                   }

                    });
                    alert.setNegativeButton("No", null);
                    alert.show();

                }
            });
        }
    }
}
