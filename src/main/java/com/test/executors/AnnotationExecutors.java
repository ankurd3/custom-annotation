package com.test.executors;

import com.test.myAnnotation.MyApp;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationExecutors {

    public String abc(){
    return fetch();
    }

    public String xyz(){
        return fetch();
    }

    private String fetch(){
        String value = null;
        StackTraceElement[] elements = new Throwable().getStackTrace();

        for(StackTraceElement e:elements){
            System.out.println(e.getClassName());
            System.out.println(e.getMethodName());
            if(e.getClassName().indexOf("CustomAnnotationApp") != -1 &&
                    (e.getMethodName().indexOf("executeAbc") != -1 ||
                            e.getMethodName().indexOf("executeXyz") != -1)){

                try {
                    Method[] methods = Class.forName(e.getClassName()).getMethods();
                    for (Method method : methods){
                        if(method.getName().equals(e.getMethodName())){
                            System.out.println("----rocking-----");
                            MyApp an = method.getAnnotation(MyApp.class);
                            return an.value();
                        }
                    }
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }

                System.out.println("--------yay-------");
            }
        }

        return value;
    }


}
