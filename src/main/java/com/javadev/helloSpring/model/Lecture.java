package com.javadev.helloSpring.model;

import java.util.Date;

public class Lecture {
    private static int nextId = 0;

    private int id;
    private String title, date;

    public Lecture(){
        super();
    }

    public Lecture(String title, String date) {
        super();
        this.id = Lecture.nextId;
        this.title = title;
        this.date = date;

        Lecture.nextId++;
    }

    public int getId() {

        return id;
    }

    public void setId() {
        this.id = Lecture.nextId++;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

