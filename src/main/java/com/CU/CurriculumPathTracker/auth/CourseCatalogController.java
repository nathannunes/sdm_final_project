package com.CU.CurriculumPathTracker.auth;


import com.CU.CurriculumPathTracker.domain.CourseCatalog;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
