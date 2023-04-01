package com.CU.CurriculumPathTracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CU.CurriculumPathTracker.entity.User;
import com.CU.CurriculumPathTracker.services.AdvisorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/soc/advisor")
public class AdvisorController {
	@Autowired
	AdvisorService advisorService;

	//Story - BE-36 Select all advisees
	@GetMapping("/getAllAdvisees")
	public ResponseEntity<?> getMyAdvisees(@AuthenticationPrincipal User user){
		return ResponseEntity.ok(advisorService.findAdvisees(user));
	}
}
