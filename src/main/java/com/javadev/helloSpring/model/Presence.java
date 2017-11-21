package com.javadev.helloSpring.model;

public class Presence {
    private static int nextId = 0;

    private int id, person_id, lecture_id;
    private StudentPresent present = StudentPresent.NOT_SET;

    public Presence() {
        super();
    }

    public Presence(int person_id, int lecture_id, StudentPresent present) {
        super();
        this.id = Presence.nextId;
        this.person_id = person_id;
        this.lecture_id = lecture_id;
        this.present = present;

        Presence.nextId++;
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = Presence.nextId++;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public int getLecture_id() {
        return lecture_id;
    }

    public void setLecture_id(int lecture_id) {
        this.lecture_id = lecture_id;
    }

    public StudentPresent getPresent() {
        return present;
    }

    public void setPresent(StudentPresent present) {
        this.present = present;
    }

    public enum StudentPresent {
        PRESENT,
        ABSENT,
        NOT_SET
    }

}

