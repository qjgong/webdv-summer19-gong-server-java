package com.example.myapp.controller;

import com.example.myapp.models.Course;
import com.example.myapp.models.Lesson;
import com.example.myapp.models.Module;
import com.example.myapp.models.Topic;
import com.example.myapp.models.Widget;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin("*")
public class CourseController {

  static Course cs4500 = new Course(234, "CS4500");
  static Course cs5610 = new Course(123, "CS5610");
  static Module cs4500W1 = new Module(123, "Week 1");
  static Module cs4500W2 = new Module(234, "Week 2");
  static Lesson lesson1 = new Lesson(123, "Lesson 1");
  static Topic topic1 = new Topic(123, "Topic 1");
  static List<Widget> widgets = new WidgetController().findAllWidgets();
  static List<Course> courses = new ArrayList<Course>();
  static List<Module> cs4500Modules = new ArrayList<>();
  static List<Lesson> cs4500W1Lessons = new ArrayList<>();
  static List<Topic> lesson1Topics = new ArrayList<>();

  {
    topic1.setWidgets(widgets);
    lesson1Topics.add(topic1);
    lesson1.setTopics(lesson1Topics);
    cs4500W1Lessons.add(lesson1);
    cs4500W1.setLessons(cs4500W1Lessons);
    cs4500Modules.add(cs4500W1);
    cs4500Modules.add(cs4500W2);
    cs4500.setModules(cs4500Modules);
    courses.add(cs5610);
    courses.add(cs4500);

  }

  @PostMapping("/api/courses")
  public void createCourse(
          @RequestBody Course course) {
    course.setId((new Random()).nextInt());
    courses.add(course);
  }

  @GetMapping("/api/courses")
  public List<Course> findAllCourses() {
    return courses;
  }

  @GetMapping("/api/courses/{courseId}")
  public Course findCourseById(
          @PathVariable("courseId") Integer id) {
    for (Course course : courses) {
      if (course.getId().equals(id)) {
        return course;
      }
    }
    return null;
  }

  @PutMapping("/api/courses/{courseId}")
  public Course updateCourse(
          @PathVariable("courseId") Integer id,
          @RequestBody Course newCourse) {

    for (Course course : courses) {
      if (course.getId().equals(id)) {
        course.setTitle(newCourse.getTitle());
        return course;
      }
    }
    return null;
  }

  @DeleteMapping("/api/courses/{courseId}")
  public void deleteCourse(@PathVariable("courseId") @RequestBody Integer id) {
    courses.removeIf(course -> course.getId().equals(id));
  }


}

