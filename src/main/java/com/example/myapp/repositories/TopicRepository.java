package com.example.myapp.repositories;


import com.example.myapp.models.Topic;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicRepository  extends CrudRepository<Topic, Integer>{

  @Query("select Topic from Topic topic")
  public List<Topic> findAllTopics();


  @Query("select Topic from Topic topic where topic.lesson.id = :lid")
  public List<Topic> findAllTopicsForLesson(@Param("lid") Integer lid);

  @Query("select Topic from Topic topic where topic.id = :id")
  public Topic findTopicById(@Param("id") Integer id);
}
