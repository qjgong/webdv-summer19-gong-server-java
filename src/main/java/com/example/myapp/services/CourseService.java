package com.example.myapp.services;

import com.example.myapp.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
  private List<Course> courses;

  public CourseService() {
    this.courses = new ArrayList<>(setUpCourses());
  }

  public void createCourse(Course course) {
    course.setId((new Random()).nextInt());
    this.courses.add(course);
  }

  public List<Course> findAllCourses() {
    return this.courses;
  }

  public Course findCourseById(Integer cid) {
    return this.courses.stream()
            .filter(c -> c.getId().equals(cid))
            .collect(Collectors.toList()).get(0);
  }

  public Course updateCourse(Integer cid, Course course) {
    this.courses = this.courses.stream()
            .map(c -> c.getId().equals(cid) ? course : c)
            .collect(Collectors.toList());
    return this.findCourseById(cid);
  }

  public void deleteCourse(Integer cid) {
    this.courses = this.courses.stream()
            .filter(c -> !c.getId().equals(cid))
            .collect(Collectors.toList());
  }


  private List<Course> setUpCourses() {
    List<Module> modules = setUpModules();
    Course cs5610 = new Course(123, "CS5610");
    Course cs5200 = new Course(234, "CS5200");
    cs5610.setModules(modules);
    List<Course> courses = new ArrayList<>();
    courses.add(cs5610);
    courses.add(cs5200);
    return courses;
  }

  private List<Topic> setUpTopics() {
    WidgetService widgetService = new WidgetService();
    List<Widget> widgets = widgetService.findAllWidgets();
    Topic dom = new Topic(1, "DOM");
    Topic tags = new Topic(2, "Tags");
    Topic attr = new Topic(3, "Attributes");
    dom.setWidgets(widgets);
    List<Topic> topics = new ArrayList<>();
    topics.add(dom);
    topics.add(tags);
    topics.add(attr);
    return topics;
  }

  private List<Lesson> setUpLessons() {
    List<Topic> topics = setUpTopics();
    Lesson html = new Lesson(1, "HTML");
    Lesson css = new Lesson(2, "CSS");
    html.setTopics(topics);
    List<Lesson> lessons = new ArrayList<>();
    lessons.add(html);
    lessons.add(css);
    return lessons;
  }

  private List<Module> setUpModules() {
    List<Lesson> lessons = setUpLessons();
    Module week1 = new Module(123, "Week 1");
    Module week2 = new Module(234, "Week 2");
    week1.setLessons(lessons);
    List<Module> modules = new ArrayList<>();
    modules.add(week1);
    modules.add(week2);
    return modules;
  }


}