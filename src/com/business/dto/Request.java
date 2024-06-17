package com.business.dto;

import java.util.Date;

public class Request {
    private String type;    //add, update, delete
    private String day;
    private Integer hour;
    private int idInstructor;
    private int idActivity;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public int getIdInstructor() {
          return idInstructor;
    }

    public void setIdInstructor(int idInstructor) {
        this.idInstructor = idInstructor;
    }

    public int getIdActivity() {
        return idActivity;
    }

    public void setIdActivity(int idActivity) {
        this.idActivity = idActivity;
    }

    public Request(String type, String day, Integer hour, int idInstructor, int idActivity) {
        this.type = type;
        this.day = day;
        this.hour = hour;
        this.idInstructor = idInstructor;
        this.idActivity = idActivity;
    }

    @Override
    public String toString() {
        return "Request{" +
                "type='" + type + '\'' +
                ", day='" + day + '\'' +
                ", hour=" + hour +
                ", idInstructor=" + idInstructor +
                ", idActivity=" + idActivity +
                '}';
    }
}
