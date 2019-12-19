package com.example.tutora;

import java.util.Random;

public class EnrolledCourseInfo {
    public static Random rnd = new Random();
    public String title;
    public int rating;
    public int img;
    public int progress;

    public EnrolledCourseInfo(String title, int rating, int img) {
        this.title = title;
        this.rating = rating;
        this.img = img;
        this.progress = rnd.nextInt(90);
    }
}
