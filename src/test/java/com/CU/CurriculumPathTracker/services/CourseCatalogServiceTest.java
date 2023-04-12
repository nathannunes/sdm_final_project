package com.CU.CurriculumPathTracker.services;

import com.CU.CurriculumPathTracker.entity.Course;
import com.CU.CurriculumPathTracker.entity.CourseCatalog;
import com.CU.CurriculumPathTracker.entity.Courses;
import com.CU.CurriculumPathTracker.repository.CourseCatalogRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CourseCatalogServiceTest {


    @Mock
    private CourseCatalogRepository courseCatalogRepository;

    @InjectMocks
    private CourseCatalogService coursesService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAll() throws JsonProcessingException {
        String code = "CS101";
        String code2 = "CS201";
        String name = "Introduction to Computer Science";
        String name2 = "Intermediate CS";
        Integer creditHours = 3;
        String courseDescription = "An introduction to computer science";
        String concentration = "Computer Science";
        JSONArray jsonArray = new JSONArray();
        jsonArray.put("[\"2023\"]");
        jsonArray.put("[\"FALL\"]");
        jsonArray.put("['CS100']");
        jsonArray.put("['CS101']");
        String prerequisites = "CS100";


        List<CourseCatalog> courses = new ArrayList<>();
        CourseCatalog course1 = new CourseCatalog(code, name, creditHours, courseDescription,
                                concentration, jsonArray.get(0).toString(), jsonArray.get(2).toString(),jsonArray.get(1).toString());
        CourseCatalog course2 = new CourseCatalog(code2, name2, creditHours, courseDescription,
                concentration, jsonArray.get(0).toString(), jsonArray.get(3).toString(),jsonArray.get(1).toString());
        courses.add(course1);
        courses.add(course2);

        when(courseCatalogRepository.findAll()).thenReturn(courses);

        String expectedJson = "{\"level\":\"grad\"," +
                "\"courses\":[{\"concentration\":\"Computer Science\"," +
                "\"subjectsList\":[{\"code\":\"CS101\",\"name\":\"Introduction to Computer Science\"," +
                "\"prequisites\":\"['CS100']\"},{\"code\":\"CS201\",\"name\":\"Intermediate CS\"," +
                "\"prequisites\":\"['CS101']\"}]}]}";

        assertEquals(expectedJson, coursesService.getAll());
    }


}