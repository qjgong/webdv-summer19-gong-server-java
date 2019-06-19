package com.example.myapp.repositories;


import com.example.myapp.models.Topic;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TopicRepository  extends CrudRepository<Topic, Integer>{

//  @Query("select topic from Topic topic")
//  public List<Topic> findAllTopics();
//
//
//  @Query("select topic from Topic topic where topic.lesson.id = :lid")
//  public List<Topic> findAllTopicsForLesson(@Param("lid") Integer lid);
//
//  @Query("select topic from Topic topic where topic.id = :id")
//  public Topic findTopicById(@Param("id") Integer id);
}