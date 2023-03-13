package com.CU.CurriculumPathTracker.entity;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.vladmihalcea.hibernate.type.json.JsonStringType;

import java.util.Date;

@Entity
@Table(name = "course_catalog")
public class CourseCatalog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_number", nullable = false)
    private Long courseNumber;

    private String code;
    private String name;

    @Column(name = "credit_hours")
    private Integer creditHours;

    @Column(name = "course_description")
    private String courseDescription;

    private String concentration;

    @Column(name = "offer_date",columnDefinition = "json")
    @JsonDeserialize
    private String offerDate;

    @Column(name = "prerequisites")
    @JsonDeserialize
    private String prerequisites;


    @Column(name = "course_semester",columnDefinition = "json")
    @JsonDeserialize
    private String courseSemester;

    public CourseCatalog(String code, String name, Integer creditHours, String courseDescription,
                         String concentration, String offerDate, String prerequisites, String courseSemester) {
        this.code = code;
        this.name = name;
        this.creditHours = creditHours;
        this.courseDescription = courseDescription;
        this.concentration = concentration;
        this.offerDate = offerDate;
        this.prerequisites = prerequisites;
        this.courseSemester = courseSemester;
    }

    public CourseCatalog() {}

    public String getOfferDate() {
        return offerDate;
    }

    public void setOfferDate(String offerDate) {
        this.offerDate = offerDate;
    }


    public Long getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(Long courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCourseSemester() {
        return courseSemester;
    }

    public void setCourseSemester(String courseSemester) {
        this.courseSemester = courseSemester;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(Integer creditHours) {
        this.creditHours = creditHours;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getConcentration() {
        return concentration;
    }

    public void setConcentration(String concentration) {
        this.concentration = concentration;
    }

    public String getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }

}
