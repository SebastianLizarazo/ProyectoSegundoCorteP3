package com.example.proyectosegundocortep3.logic;

import java.util.ArrayList;

public class Semester {
    private int id;
    private ArrayList<Subject> subjects;
    private Double finalScore;

    public Semester(int id, ArrayList<Subject> subjects, Double finalScore) {
        this.id = id;
        this.subjects = subjects;
        this.finalScore = finalScore;
    }

    public Semester(int id, Double finalScore) {
        this.id = id;
        this.subjects = new ArrayList<>();
        this.finalScore = finalScore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

    public Double getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(Double finalScore) {
        this.finalScore = finalScore;
    }

    @Override
    public String toString() {
        return "Semester{" +
                "id=" + id +
                ", subjects=" + subjects +
                ", finalScore=" + finalScore +
                '}';
    }
}
