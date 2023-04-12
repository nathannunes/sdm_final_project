package com.CU.CurriculumPathTracker.services;


import com.CU.CurriculumPathTracker.entity.Concentrations;
import com.CU.CurriculumPathTracker.entity.Course;
import com.CU.CurriculumPathTracker.entity.CourseCatalog;
import com.CU.CurriculumPathTracker.repository.CourseCatalogRepository;
import com.CU.CurriculumPathTracker.entity.Courses;
import com.CU.CurriculumPathTracker.entity.Subjects;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
            String concentration = course.getConcentration();
            if(courseMap.containsKey(concentration)){
                ArrayList<Subjects> updateMapList = courseMap.get(concentration);
                updateMapList.add(new Subjects(course.getCode(), course.getName(), course.getPrerequisites()));
            }else{
                subjectsList.add(new Subjects(course.getCode(), course.getName(), course.getPrerequisites()));
                courseMap.put(concentration, subjectsList);
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

    public CourseCatalog postNewCourse(Map<String,String> inputJson) throws ParseException, JsonProcessingException {
        //  null check
        String concentrations = null;
        JSONArray jsonArray = new JSONArray();
        if (inputJson.get("offerDate") != null && !inputJson.get("offerDate").isEmpty()) {
            //dates = objectMapper.writeValueAsString(inputJson.get("offerDate"));
            jsonArray.put(inputJson.get("offerDate"));
        }else{
            jsonArray.put("null");
        }
        if (inputJson.get("prerequisites") != null && !inputJson.get("prerequisites").isEmpty()) {
            //dates = objectMapper.writeValueAsString(inputJson.get("offerDate"));
            jsonArray.put(inputJson.get("prerequisites"));
        }else{
            jsonArray.put("null");
        }
        if (inputJson.get("courseSemester") != null && !inputJson.get("courseSemester").isEmpty()) {
            //dates = objectMapper.writeValueAsString(inputJson.get("offerDate"));
            jsonArray.put(inputJson.get("courseSemester"));
        }else{
            jsonArray.put("null");
        }

        // TODO valid concentration
        for(Concentrations concentration : Concentrations.values()){
            if(inputJson.get("concentration")!=null &&
                    concentration.name().equalsIgnoreCase(inputJson.get("concentration"))){
                concentrations = concentration.getValue();
            }else{
                System.out.println(concentration +"  " + inputJson.get("concentration"));
            }
        }

        CourseCatalog newCourse = new CourseCatalog(inputJson.get("code"), inputJson.get("name"),
                Integer.parseInt(inputJson.get("creditHours")), inputJson.get("courseDescription"),
                concentrations,
                jsonArray.get(0).toString(), jsonArray.get(1).toString(),
                jsonArray.get(2).toString());

        System.out.println(jsonArray.get(0).toString());
        courseCatalogRepository.save(newCourse);
        return newCourse;
    }

}
