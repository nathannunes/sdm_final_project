package com.CU.CurriculumPathTracker.domain;

import java.util.List;

public class Course {

    private String concentration;

    private List<Subjects> subjectsList;

    public String getConcentration() {
        return concentration;
    }

    public List<Subjects> getSubjectsList() {
        return subjectsList;
    }
    public Course(String concentration, List<Subjects> subjectsList) {
        this.concentration = concentration;
        this.subjectsList = subjectsList;
    }


}
