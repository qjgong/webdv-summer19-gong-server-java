package com.example.myapp.controller;

import com.example.myapp.models.Topic;
import com.example.myapp.models.Widget;
import com.example.myapp.services.TopicService;
import com.example.myapp.services.WidgetService;

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
public class WidgetController {

  @Autowired
  WidgetService widgetService;
  @Autowired
  TopicService topicService;

  @GetMapping("/api/widgets")
  public List<Widget> findAllWidgets() {
    return widgetService.findAllWidgets();
  }

  @GetMapping("/api/topics/{tId}/widgets")
  public List<Widget> findAllWidgetsForTopic(
          @PathVariable("tId") Integer tId) {
    return widgetService.findAllWidgetsForTopic(tId);
  }

  @PostMapping("/api/topics/{tId}/widgets")
  public List<Widget> addWidgetToTopic(
          @PathVariable("tId") Integer tId,
          @RequestBody Widget newWidget
  ) {
    Topic topic = topicService.findTopicById(tId);
    newWidget.setTopic(topic);
    widgetService.createWidget(newWidget);

    return widgetService.findAllWidgetsForTopic(tId);
  }

  @GetMapping("/api/widgets/{wid}")
  public Widget findWidgetById(@PathVariable("wid") Integer id) {
    return widgetService.findWidgetById(id);
  }


  @PutMapping("/api/widgets/{widgetId}")
  public Widget updateWidget(
          @PathVariable("widgetId") Integer wid,
          @RequestBody Widget newWidget) {
    return widgetService.updateWidget(wid, newWidget);
  }

  @PutMapping("/api/topics/{tId}/widgets")
  public List<Widget> updateOrder(
          @PathVariable("tId") Integer tId,
          @RequestBody List<Widget> wts) {


    return widgetService.updateOrder(wts,tId);
  }

  @DeleteMapping("/api/widgets/{widgetId}")
  public List<Widget> deleteWidget(@PathVariable("widgetId") Integer wid) {
    return this.widgetService.deleteWidget(wid);

  }
}
