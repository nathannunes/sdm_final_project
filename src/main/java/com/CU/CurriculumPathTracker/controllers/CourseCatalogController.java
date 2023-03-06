package com.CU.CurriculumPathTracker.controllers;


import com.CU.CurriculumPathTracker.services.CourseCatalogService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/soc/courses")
public class CourseCatalogController {

    final private CourseCatalogService courseCatalogService;

    public CourseCatalogController(CourseCatalogService courseCatalogService) {this.courseCatalogService = courseCatalogService;}

    @GetMapping("/findAll")
    public String getAllCourses() throws JsonProcessingException {
        return courseCatalogService.getAll();
    }
}
