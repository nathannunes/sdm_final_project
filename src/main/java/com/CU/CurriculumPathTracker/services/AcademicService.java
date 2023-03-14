package com.CU.CurriculumPathTracker.services;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CU.CurriculumPathTracker.entity.AcademicCalendar;
import com.CU.CurriculumPathTracker.repository.AcademicCalendarRepository;

@Service
public class AcademicService {

	@Autowired 
	AcademicCalendarRepository academicCalendarRepository;
	public Map<String,List<AcademicCalendar>> getAcademicCalendar() {
		List<AcademicCalendar> academicCalendars = academicCalendarRepository.findAll();
		Map<String,List<AcademicCalendar>> semesterAcademicCalendarsMap= new HashMap<String,List<AcademicCalendar>>();
		for(AcademicCalendar academicCalendar : academicCalendars) {
			if(!semesterAcademicCalendarsMap.containsKey(academicCalendar.getSemester())) {
				semesterAcademicCalendarsMap.put(academicCalendar.getSemester(), new ArrayList<>(Arrays.asList(academicCalendar)));
			}
			else {
				List<AcademicCalendar> existingCalendar = semesterAcademicCalendarsMap.get(academicCalendar.getSemester());
				existingCalendar.add(academicCalendar);
				semesterAcademicCalendarsMap.put(academicCalendar.getSemester(),existingCalendar);
			}
		}
		return semesterAcademicCalendarsMap;
	}
	public AcademicCalendar save(AcademicCalendar academicCalendar) {
		return academicCalendarRepository.save(academicCalendar);
	}

}
