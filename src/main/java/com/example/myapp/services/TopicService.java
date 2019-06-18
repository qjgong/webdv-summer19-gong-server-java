package com.example.myapp.services;

import com.example.myapp.models.Topic;
import com.example.myapp.repositories.LessonRepository;
import com.example.myapp.repositories.TopicRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
  @Autowired
  TopicRepository topicRepository;
  @Autowired
  LessonRepository lessonRepository;

  public Topic createTopic(Topic topic) {
    return topicRepository.save(topic);
  }

  public List<Topic> findAllTopics() {
    return (List<Topic>)topicRepository.findAll();
  }

  public List<Topic> findAllTopicsForLesson(Integer lessonId) {
    return lessonRepository.findById(lessonId).get().getTopics();
  }

  public Topic findTopicById(Integer id) {
    return topicRepository.findById(id).get();
  }

  public void deleteTopic(Integer tid) {
    Topic topic = topicRepository.findById(tid).get();
    topicRepository.delete(topic);
  }

  public Topic updateTopic(Integer id,Topic topic) {

   Topic current=topicRepository.findById(id).get();
    current.setWidgets(topic.getWidgets());
    current.setTitle(topic.getTitle());
    return topicRepository.save(current);
  }


}
