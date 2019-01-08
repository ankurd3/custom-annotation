package com.test;

import com.test.myAnnotation.MyApp;
import com.test.service.CustomService;

public class CustomAnnotationApp {

    CustomService c = new CustomService();

    public static void main(String[] args) throws ClassNotFoundException {
        CustomAnnotationApp a = new CustomAnnotationApp();
        a.execute();
    }

    @MyApp("Ankur")
    public void executeAbc() throws ClassNotFoundException {
        System.out.println(">>>"+c.sample());
    }


    public void execute() throws ClassNotFoundException {
        System.out.println(">>>"+c.sample());
    }

    @MyApp("Mou")
    public void executeXyz(){
        System.out.println(">>>"+c.test());
    }

}
