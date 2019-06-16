package com.example.myapp;

import com.example.myapp.models.Course;
import com.example.myapp.models.Lesson;
import com.example.myapp.models.Module;
import com.example.myapp.models.Topic;
import com.example.myapp.models.Widget;
import com.example.myapp.services.CourseService;
import com.example.myapp.services.LessonService;
import com.example.myapp.services.ModuleService;
import com.example.myapp.services.TopicService;
import com.example.myapp.services.WidgetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataSeeder {
  private CourseService courseService;
  private WidgetService widgetService;
  private ModuleService moduleService;
  private LessonService lessonService;
  private TopicService topicService;


  @Autowired
  public DataSeeder(CourseService courseService, WidgetService widgetService, ModuleService moduleService, LessonService lessonService, TopicService topicService) {
    this.courseService = courseService;
    this.widgetService = widgetService;
    this.moduleService = moduleService;
    this.lessonService = lessonService;
    this.topicService = topicService;

  }

  @EventListener
  public void seed(ContextRefreshedEvent event) {
//     setUpLessons();
    setUpWidgets();
    setUpTopics();
    setUpLessons();
    setUpModules();
    setUpCourses();

    System.out.println("asd");
  }

  private void setUpCourses() {
    List<Module> modules = moduleService.findAllModules();
    Course cs5610 = new Course(123, "CS5610");
    Course cs5200 = new Course(234, "CS5200");

    cs5610.setModules(modules);
    courseService.createCourse(cs5610);


    courseService.createCourse(cs5200);

  }

  private void setUpTopics() {

    List<Widget> widgets = widgetService.findAllWidgets();
    Topic dom = new Topic(1, "DOM");
    Topic tags = new Topic(2, "Tags");
    Topic attr = new Topic(3, "Attributes");
    dom.setWidgets(widgets);
    topicService.createTopic(dom);
    topicService.createTopic(tags);
    topicService.createTopic(attr);
  }

  private void setUpLessons() {
    List<Topic> topics = topicService.findAllTopics();
    Lesson html = new Lesson(1, "HTML");
    Lesson css = new Lesson(2, "CSS");
    html.setTopics(topics);
//    List<Lesson> lessons = new ArrayList<>();
//    lessons.add(html);
//    lessons.add(css);
//    return lessons;
    lessonService.createLesson(html);
    lessonService.createLesson(css);
  }

  private void setUpModules() {
    List<Lesson> lessons = lessonService.findAllLessons();
    Module week1 = new Module(123, "Week 1");
    Module week2 = new Module(234, "Week 2");
    week1.setLessons(lessons);
    moduleService.createModule(week1);
    moduleService.createModule(week2);
  }

  private void setUpWidgets() {
    List<Widget> widgets = new ArrayList<>();
    Widget heading = new Widget(123, "Widget 1", "HEADING");
    heading.setSize("h1");
    heading.setText("The Document Object Model");
    widgets.add(heading);
    Widget list = new Widget(234, "Widget 2", "LIST");
    list.setItems("Nodes,Attributes,Tag names,IDs,Styles,Classes");
    list.setListType("unordered");
    widgets.add(list);
    Widget paragraph = new Widget(345, "Widget 3", "PARAGRAPH");
    paragraph.setText("This topic introduces the DOM");
    widgets.add(paragraph);
    Widget image = new Widget(456, "Widget 4", "IMAGE");
    image.setSrc("https://picsum.photos/200");
    widgets.add(image);
    Widget link = new Widget(567, "Widget 5", "LINK");
    link.setTitle("The DOM");
    link.setHref("https://en.wikipedia.org/wiki/Document_Object_Model");
    widgets.add(link);
    widgetService.createWidget(heading);
    widgetService.createWidget(list);
    widgetService.createWidget(paragraph);
    widgetService.createWidget(image);
    widgetService.createWidget(link);
  }

}
