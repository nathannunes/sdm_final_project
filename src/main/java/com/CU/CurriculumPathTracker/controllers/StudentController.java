package com.CU.CurriculumPathTracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.CU.CurriculumPathTracker.entity.User;
import com.CU.CurriculumPathTracker.services.StudentService;

@Controller
@RequestMapping("/soc/student")
public class StudentController {
	@Autowired
	StudentService studentService;
	@GetMapping("/getEnrolledCourses")
	public ResponseEntity<?> findEnrolledCourses(@AuthenticationPrincipal User user) {
		
		return ResponseEntity.ok(studentService.findEnrolledClasses(user));
	}

}
