package com.example.myapp.services;

import com.example.myapp.models.Course;
import com.example.myapp.models.Lesson;
import com.example.myapp.repositories.LessonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

  public List<Lesson> findAllLessonsForModule(Integer mid){
    return  lessonRepository.findAllLessonsForModule(mid);
  }

  public Lesson findLessonById(Integer id){
    return lessonRepository.findLessonById(id);
  }

  public void deleteLesson(Integer lid) {
    Lesson lesson=lessonRepository.findLessonById(lid);
   lessonRepository.delete(lesson);
  }

  public Lesson updateLesson(Integer lid, Lesson lesson) {

    Lesson current=lessonRepository.findLessonById(lid);
    current.setTopics(lesson.getTopics());
    current.setTitle(lesson.getTitle());
    return lessonRepository.save(current);
  }
}
