package com.CU.CurriculumPathTracker.domain;

public class Subjects {
    private String code;
    private String name;
    private String prequisites;

    public Subjects(String code, String name, String prequisites) {
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

    public String getPrequisites() {
        return prequisites;
    }
}
