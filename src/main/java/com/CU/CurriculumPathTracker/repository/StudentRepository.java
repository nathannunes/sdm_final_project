package com.CU.CurriculumPathTracker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.CU.CurriculumPathTracker.entity.Student;

public interface StudentRepository extends JpaRepository<Student,String>{
	//@Query(value="SELECT stu.studentcuid,stu.name,stu.degree_id,stu.student_type,stu.study_plan_id FROM student stu JOIN plans_of_study pos ON stu.study_plan_id = pos.id WHERE advisor_advisorcuid = :name",
		//	nativeQuery = true)
	@Query("SELECT stu FROM Student AS stu JOIN PlansOfStudy AS pos on stu.studyPlan = pos.id WHERE pos.advisor.advisorCUId = :name") 
	Optional<List<Student>> findAdvisees(@Param("name") String username);
	
	Student findByName(String name);
}
