package com.business.service;

import com.business.dto.Planning;
import com.business.dto.Request;
import com.business.model.Activity;
import com.business.model.Instructor;
import com.sun.jdi.InvocationException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class CreatePlanning {

    public CreatePlanning() {
        System.out.println("New Instance");
    }

    public Planning planningExecute(Request request, List<Instructor> instructorsList, List<Activity> activitesList, Planning planning) {
        System.out.println("Inside Planning: " + request);

        try {
            String methodName = "setHour" + request.getDay();
            Method executeMethod = planning.getClass().getMethod(methodName, Integer.class);
            executeMethod.invoke(planning, request.getHour());

            methodName = "setName" + request.getDay() + "Instructor";
            executeMethod = planning.getClass().getMethod(methodName, String.class);
            executeMethod.invoke(planning, searchInstructor(request.getIdInstructor(), instructorsList));

            methodName = "setName" + request.getDay() + "Activity";
            executeMethod = planning.getClass().getMethod(methodName, String.class);
            executeMethod.invoke(planning, searchActivity(request.getIdActivity(), activitesList));

        } catch (NoSuchMethodException e) {
            System.out.println("Type " + request + " invalid");
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            System.out.println("Error new instance " + e.getMessage());
            e.printStackTrace();
        }
        return planning;
    }

    private String searchInstructor(Integer id, List<Instructor> instructors) {
        String name = null;
        for(Instructor instructor : instructors) {
            if(instructor.getId().equals(id)) {
                name = instructor.getName() + " " + instructor.getSurname();
            }
        }
        return name;
    }

    private String searchActivity(Integer id, List<Activity> activites) {
        String activityName = null;
        for(Activity activity : activites) {
            if(activity.getId().equals(id)) {
                activityName = activity.getActivity();
            }
        }
        return activityName;
    }
}
