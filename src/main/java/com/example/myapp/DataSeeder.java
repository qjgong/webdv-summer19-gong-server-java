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
//    setUpWidgets();
//    setUpTopics();
//    setUpLessons();
//    setUpModules();
//    setUpCourses();
    //setUpData();
    setUps();
  }

  private void setUpCourses() {
    List<Module> modules = this.setUpModules();// moduleService.findAllModules();
    Course cs5610 = new Course( "CS5610");
    Course cs5200 = new Course( "CS5200");

    cs5610.setModules(modules);
    courseService.createCourse(cs5610);
    courseService.createCourse(cs5200);

    for(Module module: modules) {
      module.setCourse(cs5610);
      moduleService.createModule(module);
    }

  }

  private void setUps(){
    List<Widget> widgets = new ArrayList<>();
    Widget heading = new Widget( "Widget 1", "HEADING");
    heading.setSize("h1");
    heading.setText("The Document Object Model");
    widgets.add(heading);
    Widget list = new Widget( "Widget 2", "LIST");
    list.setItems("Nodes,Attributes,Tag names,IDs,Styles,Classes");
    list.setListType("unordered");
    widgets.add(list);
    Widget paragraph = new Widget( "Widget 3", "PARAGRAPH");
    paragraph.setText("This topic introduces the DOM");
    widgets.add(paragraph);
    Widget image = new Widget("Widget 4", "IMAGE");
    image.setSrc("https://picsum.photos/200");
    widgets.add(image);
    Widget link = new Widget("Widget 5", "LINK");
    link.setTitle("The DOM");
    link.setHref("https://en.wikipedia.org/wiki/Document_Object_Model");
    widgets.add(link);

    Topic dom = new Topic("DOM");
    Topic tags = new Topic( "Tags");
    Topic attr = new Topic( "Attributes");
    dom.setWidgets(widgets);
    List<Topic> topics = new ArrayList<>();
    topics.add(dom);
    topics.add(tags);
    topics.add(attr);

    Lesson html = new Lesson( "HTML");
    Lesson css = new Lesson("CSS");
    html.setTopics(topics);
    List<Lesson> lessons = new ArrayList<>();
    lessons.add(html);
    lessons.add(css);

    Module week1 = new Module( "Week 1");
    Module week2 = new Module( "Week 2");
    week1.setLessons(lessons);
    List<Module> modules = new ArrayList<>();
    modules.add(week1);
    modules.add(week2);

    Course cs5610 = new Course( "CS5610");
    Course cs5200 = new Course( "CS5200");

    cs5610.setModules(modules);
    courseService.createCourse(cs5610);
    courseService.createCourse(cs5200);

    for(Module module: modules) {
      module.setCourse(cs5610);
      moduleService.createModule(module);
    }

    for(Lesson lesson: lessons) {
      lesson.setModule(week1);
      lessonService.createLesson(lesson);
    }

    for(Topic topic:topics) {
      topic.setLesson(html);
      topicService.createTopic(topic);
    }

    for(Widget widget:widgets) {
      widget.setTopic(dom);
      widgetService.createWidget(widget);
    }

  }

  private List<Topic> setUpTopics() {

    List<Widget> widgets = this.setUpWidgets();//widgetService.findAllWidgets();
    Topic dom = new Topic("DOM");
    Topic tags = new Topic( "Tags");
    Topic attr = new Topic( "Attributes");
    dom.setWidgets(widgets);
    List<Topic> topics = new ArrayList<>();
    topics.add(dom);
    topics.add(tags);
    topics.add(attr);
    return topics;
//    topicService.createTopic(dom);
//    topicService.createTopic(tags);
//    topicService.createTopic(attr);
  }

  private List<Lesson> setUpLessons() {
    List<Topic> topics = this.setUpTopics();//topicService.findAllTopics();
    Lesson html = new Lesson( "HTML");
    Lesson css = new Lesson("CSS");
    html.setTopics(topics);
    List<Lesson> lessons = new ArrayList<>();
    lessons.add(html);
    lessons.add(css);
    return lessons;
//    lessonService.createLesson(html);
//    lessonService.createLesson(css);
  }

  private List<Module> setUpModules() {
    List<Lesson> lessons = this.setUpLessons();//lessonService.findAllLessons();
    Module week1 = new Module( "Week 1");
    Module week2 = new Module( "Week 2");
    week1.setLessons(lessons);
    List<Module> modules = new ArrayList<>();
    modules.add(week1);
    modules.add(week2);
    return modules;
//    moduleService.createModule(week1);
//    moduleService.createModule(week2);
  }

  private List<Widget> setUpWidgets() {
    List<Widget> widgets = new ArrayList<>();
    Widget heading = new Widget( "Widget 1", "HEADING");
    heading.setSize("h1");
    heading.setText("The Document Object Model");
    widgets.add(heading);
    Widget list = new Widget( "Widget 2", "LIST");
    list.setItems("Nodes,Attributes,Tag names,IDs,Styles,Classes");
    list.setListType("unordered");
    widgets.add(list);
    Widget paragraph = new Widget( "Widget 3", "PARAGRAPH");
    paragraph.setText("This topic introduces the DOM");
    widgets.add(paragraph);
    Widget image = new Widget("Widget 4", "IMAGE");
    image.setSrc("https://picsum.photos/200");
    widgets.add(image);
    Widget link = new Widget("Widget 5", "LINK");
    link.setTitle("The DOM");
    link.setHref("https://en.wikipedia.org/wiki/Document_Object_Model");
    widgets.add(link);
    return widgets;
//    widgetService.createWidget(heading);
//    widgetService.createWidget(list);
//    widgetService.createWidget(paragraph);
//    widgetService.createWidget(image);
//    widgetService.createWidget(link);
  }

//  private void setUpData() {
//
//    Course cs5610 = new Course("CS5610");
//    Course cs5200 = new Course("CS5200");
//
//    Module week1 = new Module("Week 1");
//    Module week2 = new Module("Week 2");
//
//    Lesson html = new Lesson( "HTML");
//    Lesson css = new Lesson( "CSS");
//
//    Topic dom = new Topic( "DOM");
//    Topic tags = new Topic("Tags");
//    Topic attr = new Topic( "Attributes");
//
//
//    List<Widget> widgets = new ArrayList<>();
//    Widget heading = new Widget( "Widget 1", "HEADING");
//    heading.setSize("h1");
//    heading.setText("The Document Object Model");
//    widgets.add(heading);
//    heading.setTopic(dom);
//
//    Widget list = new Widget( "Widget 2", "LIST");
//    list.setItems("Nodes,Attributes,Tag names,IDs,Styles,Classes");
//    list.setListType("unordered");
//    widgets.add(list);
//    list.setTopic(dom);
//
//    Widget paragraph = new Widget( "Widget 3", "PARAGRAPH");
//    paragraph.setText("This topic introduces the DOM");
//    widgets.add(paragraph);
//    paragraph.setTopic(dom);
//
//    Widget image = new Widget( "Widget 4", "IMAGE");
//    image.setSrc("https://picsum.photos/200");
//    widgets.add(image);
//    image.setTopic(dom);
//
//    Widget link = new Widget( "Widget 5", "LINK");
//    link.setTitle("The DOM");
//    link.setHref("https://en.wikipedia.org/wiki/Document_Object_Model");
//    widgets.add(link);
//    link.setTopic(dom);
//
//
//    widgetService.createWidget(heading);
//    widgetService.createWidget(list);
//    widgetService.createWidget(paragraph);
//    widgetService.createWidget(image);
//    widgetService.createWidget(link);
//
//    //dom.setWidgets(widgets);
//    topicService.createTopic(dom);
//    topicService.createTopic(tags);
//    topicService.createTopic(attr);
//
//
//    List<Topic> topics = new ArrayList<>();
//    dom.setLesson(html);
//    tags.setLesson(html);
//    attr.setLesson(html);
//    topics.add(dom);
//    topics.add(tags);
//    topics.add(attr);
//
//    //html.setTopics(topics);
//    lessonService.createLesson(html);
//    lessonService.createLesson(css);
//
//    List<Lesson> lessons = new ArrayList<>();
//    html.setModule(week1);
//    css.setModule(week1);
//    lessons.add(html);
//    lessons.add(css);
//    //week1.setLessons(lessons);
//    moduleService.createModule(week1);
//    moduleService.createModule(week2);
//
//    List<Module> modules = new ArrayList<>();
//    week1.setCourse(cs5610);
//    week2.setCourse(cs5610);
//    modules.add(week1);
//    modules.add(week2);
//    // cs5610.setModules(modules);
//    courseService.createCourse(cs5610);
//    courseService.createCourse(cs5200);
//
//  }
//

}
