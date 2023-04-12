package com.CU.CurriculumPathTracker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.CU.CurriculumPathTracker.entity.AcademicAdvisor;
import com.CU.CurriculumPathTracker.entity.Student;




public interface AdvisorRepository extends JpaRepository<AcademicAdvisor, String>{
	

	AcademicAdvisor findByAdvisorName(String advisorName);
}
