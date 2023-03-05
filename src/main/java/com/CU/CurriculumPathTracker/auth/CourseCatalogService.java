package com.CU.CurriculumPathTracker.auth;


import com.CU.CurriculumPathTracker.domain.CourseCatalog;
import com.CU.CurriculumPathTracker.domain.CourseCatalogRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.annotations.OrderBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseCatalogService {
    @Autowired
    private final CourseCatalogRepository courseCatalogRepository;


    public CourseCatalogService(CourseCatalogRepository courseCatalogRepository) {
        this.courseCatalogRepository = null;
    }

    public String getAll() throws JsonProcessingException {

        List<CourseCatalog> allCourses = courseCatalogRepository.findAll();
        //Creating the ObjectMapper object
        ObjectMapper mapper = new ObjectMapper();
        //Converting the Object to JSONString
        String jsonString = mapper.writeValueAsString(allCourses);
        //System.out.println(jsonString);
        return jsonString;
    }


}
