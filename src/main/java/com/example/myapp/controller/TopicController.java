package com.example.myapp.controller;

import com.example.myapp.models.Lesson;
import com.example.myapp.models.Topic;
import com.example.myapp.repositories.LessonRepository;
import com.example.myapp.repositories.TopicRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class TopicController {

  @Autowired
  TopicRepository repository;
  @Autowired
  LessonRepository lessonRepository;

  @GetMapping("/api/topics")
  public List<Topic> findAllTopics() {
    return repository.findAllTopics();
  }

  @GetMapping("/api/lessons/{lId}/topics")
  public List<Topic> findAllTopicsForLesson(
          @PathVariable("lId") Integer lId) {
    return repository.findAllTopicsForLesson(lId);
  }

  @PostMapping("/api/lessons/{lId}/topics")
  public List<Topic> addTopicToLesson(
          @PathVariable("lId") Integer lId,
          @RequestBody Topic newTopic
  ) {
    Lesson lesson = lessonRepository.findLessonById(lId);
    newTopic.setLesson(lesson);
    repository.save(newTopic);
    return repository.findAllTopicsForLesson(lId);
  }

  @GetMapping("/api/topics/{tid}")
  public Topic findTopicById(@PathVariable("tid") Integer id) {
    return repository.findTopicById(id);
  }
}
