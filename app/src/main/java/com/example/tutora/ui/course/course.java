//
//package com.example.tutora.ui.course;
//
//        import android.database.Cursor;
//        import android.os.Bundle;
//        import android.view.LayoutInflater;
//        import android.view.View;
//        import android.view.ViewGroup;
//        import android.widget.Toast;
//
//        import androidx.annotation.NonNull;
//        import androidx.annotation.Nullable;
//        import androidx.fragment.app.Fragment;
//        import androidx.recyclerview.widget.LinearLayoutManager;
//        import androidx.recyclerview.widget.RecyclerView;
//
//        import com.example.tutora.R;
//        import com.example.tutora.models.sampledata.Lesson;
//
//        import java.util.ArrayList;
//
//public class course extends Fragment {
//    int id=0;
//
//    public  course(int id){
//        this.id = id;
//    }
//
//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.course, container, false);
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        RecyclerView re = view.findViewById(R.id.re);
//       // Lesson lesson = new Lesson(view.getContext());
//
//         RecyclerView.Adapter adapter;
//         RecyclerView.LayoutManager layoutManager;
//         layoutManager = new LinearLayoutManager(view.getContext());
//         re.setLayoutManager(layoutManager);
//////        Cursor cursor = lesson.getLessons(id);
//////        ArrayList<com.example.tutora.ui.course.Lesson>lessons = new ArrayList<>();
//////        //(id integer primary key autoincrement,name text,link text,courseId integer, time text, reference text,task text,image integer
//////        if(cursor.moveToFirst()){
//////         boolean flag = true;
//////            do{
//////                if(flag){
//////                    flag = !flag;
//////                    lessons.add(new com.example.tutora.ui.course.Lesson(cursor.getString(1),cursor.getString(5),cursor.getInt(8),true));
//////                }else {
//////                    lessons.add(new com.example.tutora.ui.course.Lesson(cursor.getString(1),cursor.getString(5),cursor.getInt(8),false));
//////
//////                }
//////            }while (cursor.moveToNext());
//////
//////
//////        }
//////
//////
//
//
//        Lesson lesson = new Lesson(view.getContext());
//
//        Cursor cursor = lesson.getLessons(1);
//        ArrayList<com.example.tutora.ui.course.Lesson>lessons = new ArrayList<>();
//        if(cursor.moveToFirst()){
//            boolean flag = true;
//            do{
//                if(flag){
//                    flag = !flag;
//                    lessons.add(new com.example.tutora.ui.course.Lesson(cursor.getString(1),cursor.getString(5),0,true));
//                }else {
//                    lessons.add(new com.example.tutora.ui.course.Lesson(cursor.getString(1),cursor.getString(5),0,false));
//
//                }
//                Toast.makeText(view.getContext(),cursor.getString(1),Toast.LENGTH_LONG).show();
//
//            } while (cursor.moveToNext());
//        }
//        for (com.example.tutora.ui.course.Lesson l:lessons) {
//            Toast.makeText(view.getContext(),l.name,Toast.LENGTH_LONG).show();
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        adapter = new lessonadapter(lessons);
//        re.setAdapter(adapter);
//    }
//}