package com.example.myapp;

import com.example.myapp.services.CourseService;
import com.example.myapp.services.ModuleService;
import com.example.myapp.services.WidgetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder {
  private CourseService courseService;
//  private WidgetService widgetService;
//  private ModuleService moduleService;


  @Autowired
  public DataSeeder(CourseService courseService) {
    this.courseService = courseService;

  }

  //    @EventListener
  public void seed(ContextRefreshedEvent event) {
    System.out.println("asd");
  }



}
