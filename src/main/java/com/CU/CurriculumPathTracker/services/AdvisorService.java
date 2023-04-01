package com.CU.CurriculumPathTracker.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CU.CurriculumPathTracker.entity.AcademicAdvisor;
import com.CU.CurriculumPathTracker.entity.Student;
import com.CU.CurriculumPathTracker.entity.User;
import com.CU.CurriculumPathTracker.repository.AdvisorRepository;
import com.CU.CurriculumPathTracker.repository.StudentRepository;

@Service
public class AdvisorService {
	@Autowired
	AdvisorRepository advisorRepository;
	@Autowired
	StudentRepository studentRepository;

	public List<Student> findAdvisees(User user) {
		// TODO Auto-generated method stub
		String username = user.getUsername();
		AcademicAdvisor academicAdvisor = advisorRepository.findByAdvisorName(username);
		if(academicAdvisor != null) {
			return studentRepository.findAdvisees(academicAdvisor.getAdvisorCUId()).orElse(new ArrayList<Student>());
		}
		else {
			return new ArrayList<Student>();
		}
		
	}

}
