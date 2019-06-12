package com.example.myapp.controller;

import com.example.myapp.models.Course;
import com.example.myapp.services.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


@RestController
@CrossOrigin("*")
public class CourseController {
  @Autowired
  private CourseService courseService;

  @PostMapping("/api/courses")
  public void createCourse(
          @RequestBody Course course) {
    courseService.createCourse(course);
  }

  @GetMapping("/api/courses")
  public List<Course> findAllCourses() {
    return this.courseService.findAllCourses();
  }

  @GetMapping("/api/courses/{courseId}")
  public Course findCourseById(
          @PathVariable("courseId") Integer id) {
    return this.courseService.findCourseById(id);
  }

  @PutMapping("/api/courses/{courseId}")
  public Course updateCourse(
          @PathVariable("courseId") Integer id,
          @RequestBody Course newCourse) {

    return this.courseService.updateCourse(id, newCourse);
  }

  @DeleteMapping("/api/courses/{courseId}")
  public void deleteCourse(@PathVariable("courseId") @RequestBody Integer id) {
    this.courseService.deleteCourse(id);
  }

}

