package com.test.service;

import com.test.executors.AnnotationExecutors;

public class CustomService {


    AnnotationExecutors ae = new AnnotationExecutors();

    public String sample() throws ClassNotFoundException {
        return ae.abc();
    }

    public String test(){
        return ae.xyz();
    }

}
