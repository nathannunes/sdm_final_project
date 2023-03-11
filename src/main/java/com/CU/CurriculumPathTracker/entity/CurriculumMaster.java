package com.CU.CurriculumPathTracker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CurriculumMaster {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String degree;
	private String concentration;
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getConcentration() {
		return concentration;
	}
	public void setConcentration(String concentration) {
		this.concentration = concentration;
	}
	public Integer getId() {
		return id;
	}
	public CurriculumMaster(String degree, String concentration) {
		
		this.degree = degree;
		this.concentration = concentration;
	}
	public CurriculumMaster() {}
}
