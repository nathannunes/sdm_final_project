package com.CU.CurriculumPathTracker.entity;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class PlansOfStudy {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;
public void setId(Integer id) {
	this.id = id;
}
@ManyToOne(fetch = FetchType.EAGER)
private AcademicAdvisor advisor;
@ElementCollection
private List<CourseCatalog> courses;
public AcademicAdvisor getAdvisor() {
	return advisor;
}
public void setAdvisor(AcademicAdvisor advisor) {
	this.advisor = advisor;
}
public List<CourseCatalog> getCourses() {
	return courses;
}
public void setCourses(List<CourseCatalog> courses) {
	this.courses = courses;
}
public Integer getId() {
	return id;
}
public PlansOfStudy(AcademicAdvisor advisor,List<CourseCatalog> courses) {
	
	this.advisor = advisor;
	this.courses = courses;
	
}
public PlansOfStudy() {}
@Override
public String toString() {
	return "PlansOfStudy [id=" + id + ", advisor=" + advisor + ", courses=" + courses + "]";
}
}
