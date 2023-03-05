package com.CU.CurriculumPathTracker.domain;

import org.springframework.core.annotation.Order;

import java.util.List;

public class Courses {
    private String level;



    @Order
    private List<Course> courses;

    public Courses(){}

    public Courses(String level, List<Course> courses) {
        this.level = level;
        this.courses = courses;
    }

    public String getLevel() {
        return level;
    }

    public List<Course> getCourses() {
        return courses;
    }

}
