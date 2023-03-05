package com.CU.CurriculumPathTracker.auth;


import com.CU.CurriculumPathTracker.domain.CourseCatalog;
import com.CU.CurriculumPathTracker.domain.CourseCatalogRepository;
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

    public List<CourseCatalog> getAll(){
        return courseCatalogRepository.findAll();
    }


}
