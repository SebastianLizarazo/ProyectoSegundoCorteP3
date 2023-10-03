package com.example.proyectosegundocortep3.logic;

public class Subject {

    private int id;
    private String name;
    private int numActivities;
    private Double finalScore;

    private Semester semester;



    public Subject(int id, String name, Double finalScore) {
        this.id = id;
        this.name = name;
        this.numActivities = 0;
        this.finalScore = finalScore;
    }

    public Subject(int id, String name, Double finalScore,Semester semester) {
        this.id = id;
        this.name = name;
        this.numActivities = 0;
        this.finalScore = finalScore;
        this.semester = semester;
    }

    public Subject(String name, Double finalScore) {
        this.name = name;
        this.numActivities = 0;
        this.finalScore = finalScore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumActivities() {
        return numActivities;
    }

    public void setNumActivities(int numActivities) {
        this.numActivities = numActivities;
    }

    public Double getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(Double finalScore) {
        this.finalScore = finalScore;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numActivities=" + numActivities +
                ", finalScore=" + finalScore +
                ", semester=" + semester +
                '}';
    }
}
