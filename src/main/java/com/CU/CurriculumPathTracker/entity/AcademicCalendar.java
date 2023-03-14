package com.CU.CurriculumPathTracker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AcademicCalendar {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;
private String semester;
private String date;
private String event;
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getEvent() {
	return event;
}
public void setEvent(String event) {
	this.event = event;
}
public Integer getId() {
	return id;
}
public String getSemester() {
	return semester;
}
public void setSemester(String semester) {
	this.semester = semester;
}
@Override
public String toString() {
	return "AcademicCalendar [id=" + id + ", semester=" + semester + ", date=" + date + ", event=" + event + "]";
}

}
