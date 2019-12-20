package com.example.tutora.ui.course;

public class Lesson {
    public Lesson(String name,String time,int Idimage,boolean seeen){
        this.seen = seeen;
        this.idImge = Idimage;
        this.name = name;
        this.time = time;
    }
    public String time;
    public  String name;
    public  int idImge;
    public boolean seen;
}
