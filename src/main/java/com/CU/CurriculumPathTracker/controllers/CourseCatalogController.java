package com.CU.CurriculumPathTracker.controllers;


import com.CU.CurriculumPathTracker.entity.Role;
import com.CU.CurriculumPathTracker.entity.User;
import com.CU.CurriculumPathTracker.services.AuthenticateService;
import com.CU.CurriculumPathTracker.services.CourseCatalogService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@RestController
@RequestMapping("/soc/courses")
public class CourseCatalogController {
    Logger logger = LoggerFactory.getLogger(CourseCatalogController.class);

    private final CourseCatalogService courseCatalogService;
    private final AuthenticateService authService;

    public CourseCatalogController(CourseCatalogService courseCatalogService, AuthenticateService authService) {this.courseCatalogService = courseCatalogService;
        this.authService = authService;
    }

    @GetMapping("/findAll")
    public String getAllCourses() throws JsonProcessingException {
        return courseCatalogService.getAll();
    }

    @PostMapping("/modifyByCode/{code}")
    public ResponseEntity<?> modifyByCode(@AuthenticationPrincipal User user){
        //TODO : check if course doesn't exist or no User rights then throw error,
        // if exists replace subject with details in JSON

        try {
            if (user.getRole().equals(Role.ADMIN)||user.getRole().equals(Role.ACAD_ADMIN)) {
                logger.info("Starting the modification......");

                return ResponseEntity.ok(true);
            } else {
                logger.error("improper role or token is not valid");
                return ResponseEntity.ok(false);
            }
        }catch (Exception ex){
            logger.error(String.valueOf(ex));
            return ResponseEntity.ok(false);
        }
    }


    @PostMapping(value = "/createNewCourse", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createNewCourse(@AuthenticationPrincipal User user,
                                             @RequestBody Map<String,String> inputJson){
        // TODO pass data the constructor to create new course
        try{
            if (1==1 /*|| user.getRole().equals(Role.ADMIN)||user.getRole().equals(Role.ACAD_ADMIN)*/) {
                logger.info("Starting the modification......");
                courseCatalogService.postNewCourse(inputJson);
                return ResponseEntity.ok(true);
            } else {
                logger.error("improper role or token is not valid");
                return ResponseEntity.ok(false);
            }
        }catch(Exception ex) {
            logger.error("Something went wrong " + ex);
            return ResponseEntity.ok(false);
        }
    }

}
