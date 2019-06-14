package com.example.myapp.controller;

import com.example.myapp.models.Widget;
import com.example.myapp.repositories.WidgetRepository;
import com.example.myapp.services.WidgetService;
import com.example.myapp.models.Lesson;
import com.example.myapp.models.Topic;
import com.example.myapp.repositories.LessonRepository;
import com.example.myapp.repositories.TopicRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
public class WidgetController {

  @Autowired
  WidgetRepository repository;
  @Autowired
  TopicRepository topicRepository;

  @GetMapping("/api/widgets")
  public List<Widget> findAllWidgets() {
    return repository.findAllWidgets();
  }

  @GetMapping("/api/topics/{tId}/widgets")
  public List<Widget> findAllWidgetsForTopic(
          @PathVariable("lId") Integer tId) {
    return repository.findAllWidgetsForTopic(tId);
  }

  @PostMapping("/api/topics/{tId}/widgets")
  public List<Widget> addWidgetToTopic(
          @PathVariable("lId") Integer tId,
          @RequestBody Widget newWidget
  ) {
    Topic topic= topicRepository.findTopicById(tId);
    newWidget.setTopic(topic);
    repository.save(newWidget);
    return repository.findAllWidgetsForTopic(tId);
  }

  @GetMapping("/api/widgets/{wid}")
  public Widget findWidgetById(@PathVariable("wid") Integer id) {
    return repository.findWidgetById(id);
  }

//  private WidgetService widgetService;
//
//  public WidgetController() {
//    this.widgetService = new WidgetService();
//  }
//
//
//  @PostMapping("/api/widgets")
//  public List<Widget> createWidget(@RequestBody Widget widget) {
//    return this.widgetService.createWidget(widget);
//  }
//
//  @GetMapping("/api/widgets")
//  public List<Widget> findAllWidgets() {
//    return this.widgetService.findAllWidgets();
//  }
//
//  @GetMapping("/api/widgets/{widgetId}")
//  public Widget findWidgetById(@PathVariable("widgetId") Integer wid) {
//    return this.widgetService.findWidgetById(wid);
//  }
//
//  @PutMapping("/api/widgets/{widgetId}")
//  public Widget updateWidget(
//          @PathVariable("widgetId") Integer wid,
//          @RequestBody Widget newWidget) {
//    return this.widgetService.updateWidget(wid, newWidget);
//  }
//
//  @PutMapping("/api/widgets")
//  public List<Widget> updateOrder(
//          @RequestBody List<Widget> wts) {
//    return this.widgetService.updateOrder(wts);
//  }
//
//  @DeleteMapping("/api/widgets/{widgetId}")
//  public List<Widget> deleteWidget(@PathVariable("widgetId") Integer wid) {
//    return this.widgetService.deleteWidget(wid);
//
//  }
}
