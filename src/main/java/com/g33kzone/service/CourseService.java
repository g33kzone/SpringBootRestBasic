package com.g33kzone.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.g33kzone.SpringRestBasicApplication;
import com.g33kzone.pojo.Course;

@Service
public class CourseService {

	public void addCourse(String name) {

		int maxSize = SpringRestBasicApplication.courseList.size() + 1;

		SpringRestBasicApplication.courseList.add(new Course(maxSize, name));
	}

	public void deleteCourse(String name) {

		for (Course course : SpringRestBasicApplication.courseList) {

			if (course.getCourseName().equals(name)) {
				SpringRestBasicApplication.courseList.remove(course);
			}
		}
	}

	public List<Course> fetchCourseById(Integer id) {

		return (List<Course>) SpringRestBasicApplication.courseList.stream().filter(t -> id.equals(t.getCourseId()))
				.collect(Collectors.toList());
	}

	public List<Course> fetchCourseByName(String name) {

		return (List<Course>) SpringRestBasicApplication.courseList.stream().filter(t -> name.equals(t.getCourseName()))
				.collect(Collectors.toList());
	}
}
