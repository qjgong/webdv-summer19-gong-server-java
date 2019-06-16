package com.example.myapp.services;

import com.example.myapp.models.Lesson;
import com.example.myapp.repositories.LessonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
@Service

public class LessonService {
  @Autowired
  LessonRepository lessonRepository;
  public Lesson createLesson(Lesson lesson){
    return lessonRepository.save(lesson);
  }

  public List<Lesson> findAllLessons(){
    return lessonRepository.findAllLessons();
  }

}
