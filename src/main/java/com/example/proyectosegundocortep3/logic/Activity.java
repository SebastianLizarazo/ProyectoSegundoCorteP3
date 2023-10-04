package com.example.proyectosegundocortep3.logic;

import java.time.LocalDate;

public class Activity {
    private int id;
    private String activityType;
    private Double weighted;
    private LocalDate deadLine;
    private Double score;
    private String state;

    private int idSubject;

    public Activity(int id, String activityType, Double weighted, LocalDate deadLine, Double score, String state, int idSubject) {
        this.id = id;
        this.activityType = activityType;
        this.weighted = weighted;
        this.deadLine = deadLine;
        this.score = score;
        this.state = state;
        this.idSubject = idSubject;
    }

    public Activity(int id, String activityType, Double weighted, LocalDate deadLine, Double score, String state) {
        this.id = id;
        this.activityType = activityType;
        this.weighted = weighted;
        this.deadLine = deadLine;
        this.score = score;
        this.state = state;
        this.idSubject = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }

    public Double getWeighted() {
        return weighted;
    }

    public void setWeighted(Double weighted) {
        this.weighted = weighted;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }


}
