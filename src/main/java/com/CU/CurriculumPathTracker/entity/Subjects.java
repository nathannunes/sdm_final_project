package com.CU.CurriculumPathTracker.entity;

import java.util.List;

public class Subjects {
    private String code;
    private String name;
    private List<String> prequisites;

    public Subjects(String code, String name, List<String> prequisites) {
        this.code = code;
        this.name = name;
        this.prequisites = prequisites;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public List<String> getPrequisites() {
        return prequisites;
    }
}
