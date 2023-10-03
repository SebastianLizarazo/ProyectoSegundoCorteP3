package com.example.proyectosegundocortep3.logic;

import java.time.LocalDate;

public class Activity {
    private int id;
    private String activityType;
    private Double weighted;
    private LocalDate deadLine;
    private Double score;
    private String state;

    private Subject subject;

    public Activity(int id, String activityType, Double weighted, LocalDate deadLine, Double score, String state, Subject subject) {
        this.id = id;
        this.activityType = activityType;
        this.weighted = weighted;
        this.deadLine = deadLine;
        this.score = score;
        this.state = state;
        this.subject = subject;
    }

    public Activity(int id, String activityType, Double weighted, LocalDate deadLine, Double score, String state) {
        this.id = id;
        this.activityType = activityType;
        this.weighted = weighted;
        this.deadLine = deadLine;
        this.score = score;
        this.state = state;
        this.subject = new Subject();
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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", activityType='" + activityType + '\'' +
                ", weighted=" + weighted +
                ", deadLine=" + deadLine +
                ", score=" + score +
                ", state='" + state + '\'' +
                ", subject=" + subject +
                '}';
    }
}
