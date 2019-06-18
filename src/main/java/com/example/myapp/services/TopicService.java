package com.example.myapp.services;

import com.example.myapp.models.Topic;
import com.example.myapp.repositories.TopicRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
  @Autowired
  TopicRepository topicRepository;

  public Topic createTopic(Topic topic) {
    return topicRepository.save(topic);
  }

  public List<Topic> findAllTopics() {
    return topicRepository.findAllTopics();
  }

  public List<Topic> findAllTopicsForLesson(Integer lessonId) {
    return topicRepository.findAllTopicsForLesson(lessonId);
  }

  public Topic findTopicById(Integer id) {
    return topicRepository.findTopicById(id);
  }

  public void deleteTopic(Integer tid) {
    Topic topic = topicRepository.findTopicById(tid);
    topicRepository.delete(topic);
  }

  public Topic updateTopic(Integer id,Topic topic) {

   Topic current=topicRepository.findTopicById(id);
    current.setWidgets(topic.getWidgets());
    current.setTitle(topic.getTitle());
    return topicRepository.save(current);
  }


}
