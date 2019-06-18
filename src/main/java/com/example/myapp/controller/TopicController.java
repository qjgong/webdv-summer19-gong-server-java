package com.example.myapp.controller;

import com.example.myapp.models.Lesson;
import com.example.myapp.models.Topic;
import com.example.myapp.services.LessonService;
import com.example.myapp.services.TopicService;

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
public class TopicController {
  @Autowired
  TopicService topicService;
  @Autowired
  LessonService lessonService;

  @PostMapping("/api/topics")
  public void createTopic(
          @RequestBody Topic m) {
    topicService.createTopic(m);
  }
  @GetMapping("/api/topics")
  public List<Topic> findAllTopics(){
    return topicService.findAllTopics();
  }
  @GetMapping("/api/lessons/{id}/topics")
  public List<Topic> findAllTopicsForLesson(
          @PathVariable("id") Integer Id) {
    return topicService.findAllTopicsForLesson(Id);
  }

  @PostMapping("/api/lessons/{id}/topics")
  public List<Topic> addTopicToLesson(
          @PathVariable("id") Integer lId,
          @RequestBody Topic newTopic
  ) {
    Lesson lesson = lessonService.findLessonById(lId);
    newTopic.setLesson(lesson);
    topicService.createTopic(newTopic);

    return topicService.findAllTopicsForLesson(lId);
  }


  @PutMapping("/api/topics/{id}")
  public Topic updateTopic(
          @PathVariable("id") Integer id,
          @RequestBody Topic topic) {

    return topicService.updateTopic(id, topic);
  }

  @GetMapping("/api/topics/{id}")
  public Topic findTopicById(@PathVariable("id") Integer id) {
    return topicService.findTopicById(id);
  }

  @DeleteMapping("/api/topics/{Id}")
  public void deleteTopic(@PathVariable("Id") Integer id) {
    this.topicService.deleteTopic(id);
  }
}
