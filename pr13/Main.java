package com.company;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String ... args){
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        Student student = context.getBean(Student.class);
    }
}
