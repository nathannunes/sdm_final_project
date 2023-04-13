package com.CU.CurriculumPathTracker.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CU.CurriculumPathTracker.entity.CourseCatalog;
import com.CU.CurriculumPathTracker.entity.PlansOfStudy;
import com.CU.CurriculumPathTracker.entity.Student;
import com.CU.CurriculumPathTracker.entity.User;
import com.CU.CurriculumPathTracker.repository.StudentRepository;


@Service
public class StudentService {
	@Autowired
	StudentRepository studentRepository;

	public List<CourseCatalog> findEnrolledClasses(User user) {		
		Student student = studentRepository.findByName(user.getUsername());
		List<CourseCatalog> courses = new ArrayList<>();
		if(student != null) {
			PlansOfStudy plansOfStudy = student.getStudyPlan();
			courses = plansOfStudy.getCourses();
		}
		return courses;
	}
	
	
}
