package com.CU.CurriculumPathTracker.services;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.CU.CurriculumPathTracker.entity.CourseCatalog;
import com.CU.CurriculumPathTracker.entity.PlansOfStudy;
import com.CU.CurriculumPathTracker.entity.Student;
import com.CU.CurriculumPathTracker.entity.User;
import com.CU.CurriculumPathTracker.repository.StudentRepository;
import com.CU.CurriculumPathTracker.services.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class StudentServiceTest {
	@Mock
	StudentRepository studentRepository;
	
	@InjectMocks
	StudentService studentService;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void test() throws JsonProcessingException {
		CourseCatalog cc1 = new CourseCatalog();
		cc1.setCourseNumber(1L);
		cc1.setCode("CPSC-6720");
		cc1.setConcentration("Software Engineering");
		cc1.setCourseDescription("Software Development Methodology");
		cc1.setCreditHours(3);
		cc1.setName("Software Development Methodology");
		
		CourseCatalog cc2 = new CourseCatalog();
		cc2.setCourseNumber(2L);
		cc2.setCode("CPSC-6620");
		cc2.setConcentration("Data Science");
		cc2.setCourseDescription("Database Management Systems");
		cc2.setCreditHours(3);
		cc2.setName("Database Management Systems");
		
		List<CourseCatalog> courses= new ArrayList<>();
		courses.add(cc1);
		courses.add(cc2);
		
		PlansOfStudy pos = new PlansOfStudy();
		pos.setId(1);
		pos.setCourses(courses);
		
		Student stu = new Student();
		stu.setStudentCUId("STU_1");
		stu.setName("testuser7");
		stu.setStudyPlan(pos);
		
		when(studentRepository.findByName("testuser7")).thenReturn(stu);
		
		String expectedJson = "[{\"courseNumber\":1,\"code\":\"CPSC-6720\",\"name\":\"Software Development Methodology\",\"creditHours\":3,\"courseDescription\":\"Software Development Methodology\",\"concentration\":\"Software Engineering\",\"offerDate\":\"null\",\"prerequisites\":\"null\",\"courseSemester\":\"null\"},{\"courseNumber\":2,\"code\":\"CPSC-6620\",\"name\":\"Database Management Systems\",\"creditHours\":3,\"courseDescription\":\"Database Management Systems\",\"concentration\":\"Data Science\",\"offerDate\":\"null\",\"prerequisites\":\"null\",\"courseSemester\":\"null\"}]";
		
		User user = new User();
		user.setUsername("testuser7");
		user.setPassword("123456");
		ObjectMapper mapper = new ObjectMapper();
        //Converting the Object to JSONString
        
		assertEquals(expectedJson, mapper.writeValueAsString(studentService.findEnrolledClasses(user)));
	}

}
