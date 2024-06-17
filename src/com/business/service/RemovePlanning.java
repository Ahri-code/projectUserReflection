package com.business.service;

import com.business.dto.Planning;
import com.business.dto.Request;
import com.business.model.Activity;
import com.business.model.Instructor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class RemovePlanning {

    public RemovePlanning() {
        System.out.println("New Instance");
    }

    public Planning planningExecute(Request request, List<Instructor> instructorsList, List<Activity> activitesList, Planning planning) {

        System.out.println("Inside Planning: " + request);

        try {
            String methodName = "setHour" + request.getDay();
            Method executeMethod = planning.getClass().getMethod(methodName, Integer.class);
            executeMethod.invoke(planning, (Integer)null);

            methodName = "setName" + request.getDay() + "Instructor";
            executeMethod = planning.getClass().getMethod(methodName, String.class);
            executeMethod.invoke(planning, (String)null);

            methodName = "setName" + request.getDay() + "Activity";
            executeMethod = planning.getClass().getMethod(methodName, String.class);
            executeMethod.invoke(planning, (String)null);

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
}
