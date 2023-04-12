package com.CU.CurriculumPathTracker.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CU.CurriculumPathTracker.entity.AcademicCalendar;
import com.CU.CurriculumPathTracker.services.AcademicService;

@RestController
@RequestMapping("/soc/academic")
public class AcademicController {
	@Autowired
	AcademicService academicService;

	@GetMapping("/getAcademicCalendar")
	public ResponseEntity<?> getAcademicCalendar() {
		Map<String,List<AcademicCalendar>> semesterAcademicCalendarsMap = academicService.getAcademicCalendar();
		
		return ResponseEntity.ok(semesterAcademicCalendarsMap);
	}
	
	@PostMapping("/saveAcademicCalendar")
	public ResponseEntity<?> saveAcademicCalendar(@RequestBody AcademicCalendar academicCalendar){
		return ResponseEntity.ok(academicService.save(academicCalendar));
	}
}
