package com.CU.CurriculumPathTracker.auth;


import com.CU.CurriculumPathTracker.domain.Course;
import com.CU.CurriculumPathTracker.domain.CourseCatalog;
import com.CU.CurriculumPathTracker.domain.CourseCatalogRepository;
import com.CU.CurriculumPathTracker.domain.Courses;
import com.CU.CurriculumPathTracker.domain.Subjects;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CourseCatalogService {
    @Autowired
    private final CourseCatalogRepository courseCatalogRepository;

    private final HashMap<String, ArrayList<Subjects>>courseMap = new HashMap<>();

    public CourseCatalogService(CourseCatalogRepository courseCatalogRepository) {
        this.courseCatalogRepository = courseCatalogRepository;
    }


    public String getAll() throws JsonProcessingException {


        List<Course> courseList = new ArrayList<>();
        Courses courses = new Courses();
        List<CourseCatalog> allCourses = courseCatalogRepository.findAll();
        allCourses.stream().sorted((i1, i2) -> i2.getConcentration().compareTo(i1.getConcentration())).collect(Collectors.toList());

        for(CourseCatalog course : allCourses){
            ArrayList<Subjects> subjectsList = new ArrayList<>();
            String conc = course.getConcentration();
            if(courseMap.containsKey(conc)){
                ArrayList<Subjects> updateMapList = courseMap.get(conc);
                updateMapList.add(new Subjects(course.getCode(), course.getName(), course.getPrerequisites()));
            }else{
                subjectsList.add(new Subjects(course.getCode(), course.getName(), course.getPrerequisites()));
                courseMap.put(conc, subjectsList);
            }

        }

        courseMap.forEach((k,v) -> courseList.add(new Course(k,v)));
        courses = new Courses("grad" , courseList);

        //Creating the ObjectMapper object
        ObjectMapper mapper = new ObjectMapper();
        //Converting the Object to JSONString
        String jsonString = mapper.writeValueAsString(courses);
        return jsonString;
    }


}
