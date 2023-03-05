package com.CU.CurriculumPathTracker.auth;


import com.CU.CurriculumPathTracker.domain.CourseCatalog;
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
    public List<CourseCatalog> getAllNotes()
    {
        return courseCatalogService.getAll();
    }
}
