package com.test;

import com.test.myAnnotation.MyApp;
import com.test.service.CustomService;

public class CustomAnnotationApp {

    CustomService c = new CustomService();

    public static void main(String[] args) {
        CustomAnnotationApp a = new CustomAnnotationApp();
        a.executeXyz();
    }

    @MyApp("Ankur")
    public void executeAbc(){
        System.out.println(c.sample());
    }

    @MyApp("Mou")
    public void executeXyz(){
        System.out.println(c.test());
    }

}
