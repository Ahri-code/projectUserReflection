package com.business.service;

import com.business.dto.Planning;
import com.business.dto.Request;
import com.business.model.Activity;
import com.business.model.Instructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class ServicePlanning {

    public Planning planningManager(Request request, List<Instructor> instructorsList, List<Activity> activitesList, Planning plan) {
        String packageName = "com.business.service";
        String className = request.getType() + "Planning";

        System.out.println("Class execute: " + packageName + "." + className);

        try {
            Class cl = Class.forName(packageName + "." + className);
            Constructor[] ctors = cl.getConstructors();
            Constructor ctorSelected = null;

            for (Constructor ctor : ctors) {
                if (ctor.getGenericParameterTypes().length == 0) {
                    ctorSelected = ctor;
                }
                    Object myClass = ctorSelected.newInstance();
                    System.out.println("After new instance");
                    String methodName = "planningExecute";
                    Method executeMethod = myClass.getClass().getMethod(methodName, Request.class, List.class, List.class, Planning.class);

                    return (Planning)executeMethod.invoke(myClass, request, instructorsList, activitesList, plan);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("tipo " + request + " invalid");
        } catch (NoSuchMethodException |SecurityException e) {
        throw new RuntimeException(e);
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException| InvocationTargetException e) {
            System.out.println("Error in new Instance " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
