package com.CU.CurriculumPathTracker.entity;

import com.CU.CurriculumPathTracker.enums.StudentType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Student {
@Id
private String studentCUId;
private String name;
@OneToOne
private CurriculumMaster degree;
@Enumerated(EnumType.STRING)
private StudentType studentType;
@ManyToOne
private PlansOfStudy studyPlan;
public String getStudentCUId() {
	return studentCUId;
}
public void setStudentCUId(String studentCUId) {
	this.studentCUId = studentCUId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public CurriculumMaster getDegree() {
	return degree;
}
public void setDegree(CurriculumMaster degree) {
	this.degree = degree;
}
public StudentType getStudentType() {
	return studentType;
}
public void setStudentType(StudentType studentType) {
	this.studentType = studentType;
}

public PlansOfStudy getStudyPlan() {
	return studyPlan;
}
public void setStudyPlan(PlansOfStudy studyPlan) {
	this.studyPlan = studyPlan;
}
public Student(String studentCUId, String name, CurriculumMaster degree, StudentType studentType,
		PlansOfStudy studyPlan) {
	this.studentCUId = studentCUId;
	this.name = name;
	this.degree = degree;
	this.studentType = studentType;
	this.studyPlan = studyPlan;
}
public Student() {}
}
