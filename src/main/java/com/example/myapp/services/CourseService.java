package com.example.myapp.services;

import com.example.myapp.models.Course;
import com.example.myapp.repositories.CourseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

  @Autowired
  CourseRepository courseRepository;


  public void createCourse(Course course) {
    courseRepository.save(course);
  }

  public List<Course> findAllCourses() {
    return (List<Course>)courseRepository.findAll();}

  public Course findCourseById(Integer cid) {
    return courseRepository.findById(cid).get();
   // return courseRepository.findCourseById(cid);
  }

  public Course updateCourse(Integer cid, Course course) {
    Course current=courseRepository.findById(cid).get();
    current.setModules(course.getModules());
    current.setTitle(course.getTitle());
    return courseRepository.save(current);
  }

  public void deleteCourse(Integer cid) {
    Course course=courseRepository.findById(cid).get();
   courseRepository.delete(course);
  }


}
