package com.company;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Student {
    @Value(value = "${student.name:Petr}")
    private String name;

    @Value("${student.last_name:Shirokov}")
    private String last_name;

    @Value("${student.group:IKBO-01-19}")
    private String group;

    @PostConstruct
    public void init() {
        System.out.println(name);
        System.out.println(last_name);
        System.out.println(group);
    }
}
