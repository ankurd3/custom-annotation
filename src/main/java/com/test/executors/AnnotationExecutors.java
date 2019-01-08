package com.test.executors;

import com.test.myAnnotation.MyApp;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class AnnotationExecutors {

    public String abc() throws ClassNotFoundException {
    return fetchUsingStream();
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
                            value = an.value();
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

    private String fetchUsingStream() throws  ClassNotFoundException{
        String value = null;
        StackTraceElement[] traces = new Throwable().getStackTrace();

        Stream<StackTraceElement> elements = Arrays.stream(traces);

        StackTraceElement st = elements.filter(e -> e.getClassName().indexOf("CustomAnnotationApp") != -1 &&
                   (e.getMethodName().indexOf("executeAbc") != -1 ||
                            e.getMethodName().indexOf("executeXyz") != -1))
                .findAny()
                .orElse(null);

        if(st != null){
            Method method = Arrays.stream(Class.forName(st.getClassName()).getMethods())
                    .filter(m->m.getName().equals(st.getMethodName()))
                    .findAny()
                    .orElse(null);

            if(method != null){
                value = method.getAnnotation(MyApp.class).value();
            }
        }

        return value;
    }


}
