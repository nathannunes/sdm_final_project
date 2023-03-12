package com.CU.CurriculumPathTracker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AcademicAdvisor {
	@Id
	private String advisorCUId;
	private String advisorName;
	private String advisorEmail;
	private String advisorSchool;
	private String department;
	public String getAdvisorCUId() {
		return advisorCUId;
	}
	public void setAdvisorCUId(String advisorCUId) {
		this.advisorCUId = advisorCUId;
	}
	public String getAdvisorName() {
		return advisorName;
	}
	public void setAdvisorName(String advisorName) {
		this.advisorName = advisorName;
	}
	public String getAdvisorEmail() {
		return advisorEmail;
	}
	public void setAdvisorEmail(String advisorEmail) {
		this.advisorEmail = advisorEmail;
	}
	public String getAdvisorSchool() {
		return advisorSchool;
	}
	public void setAdvisorSchool(String advisorSchool) {
		this.advisorSchool = advisorSchool;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public AcademicAdvisor(String advisorCUId, String advisorName, String advisorEmail, String advisorSchool,
			String department) {
		
		this.advisorCUId = advisorCUId;
		this.advisorName = advisorName;
		this.advisorEmail = advisorEmail;
		this.advisorSchool = advisorSchool;
		this.department = department;
	}
	public AcademicAdvisor() {}
}
