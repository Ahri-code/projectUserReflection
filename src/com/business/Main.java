package com.business;

import com.business.dto.Planning;
import com.business.dto.Request;
import com.business.model.Activity;
import com.business.model.Instructor;
import com.business.service.ServicePlanning;
import com.business.utilities.Utility;

import java.util.ArrayList;
import java.util.List;

public class Main extends Utility {
    public static void main(String[] args) {

        final String activityPath ="D:\\IntelliJ\\Academy\\Files\\Activities.txt";
        final String instructorPath ="D:\\IntelliJ\\Academy\\Files\\Instructor.txt";
        List<String> input = readLine(activityPath);
        List<Activity> activities = loadActivities(input);
        System.out.println("Number of activities: " + activities.size());

        input = readLine(instructorPath);
        List<Instructor> instructor = loadInstructor(input);
        System.out.println("Number of instructor: " + instructor.size());

        Request rq = new Request("Create", "Monday", 10, 1, 4);
        Request re = new Request("Create", "Friday", 10, 1, 4);
        Request rm = new Request("Remove", "Monday", 10, 1, 4);

//        new ServicePlanning().planningManager(rq, instructor, activities);

        Planning plan = new Planning();
        plan = new ServicePlanning().planningManager(rq, instructor, activities, plan);
        plan = new ServicePlanning().planningManager(re, instructor, activities, plan);
        System.out.println(plan);
        plan = new ServicePlanning().planningManager(rm, instructor, activities, plan);
        System.out.println(plan);
    }

    private static List<Activity> loadActivities(List<String> input) {

        List<Activity> resp = new ArrayList<Activity>();
        String[] token = null;
        Activity activity = null;
        for(String item : input) {
            activity = new Activity();
            token = item.split(",");
            activity.setId(Integer.parseInt(token[0]));
            activity.setActivity(token[1]);
            resp.add(activity);
        }

        return resp;
    }

    private static List<Instructor> loadInstructor(List<String> input) {

        List<Instructor> resp = new ArrayList<Instructor>();
        String[] token = null;
        Instructor instructor = null;
        for(String item : input) {
            instructor = new Instructor();
            token = item.split(",");
            instructor.setId(Integer.parseInt(token[0]));
            instructor.setSurname(token[1]);
            instructor.setName(token[2]);
            instructor.setIdActivity(Integer.parseInt(token[3]));
            resp.add(instructor);
        }

        return resp;
    }
}