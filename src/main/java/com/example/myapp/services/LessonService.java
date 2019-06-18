package com.example.myapp.services;

import com.example.myapp.models.Lesson;
import com.example.myapp.repositories.LessonRepository;
import com.example.myapp.repositories.ModuleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class LessonService {
  @Autowired
  LessonRepository lessonRepository;
  @Autowired
  ModuleRepository moduleRepository;
  public Lesson createLesson(Lesson lesson){
    return lessonRepository.save(lesson);
  }

  public List<Lesson> findAllLessons(){
    return (List<Lesson>)lessonRepository.findAll();
  }

  public List<Lesson> findAllLessonsForModule(Integer mid){
    return  moduleRepository.findById(mid).get().getLessons();
  }

  public Lesson findLessonById(Integer id){
    return lessonRepository.findById(id).get();
  }

  public void deleteLesson(Integer lid) {
    Lesson lesson=lessonRepository.findById(lid).get();
   lessonRepository.delete(lesson);
  }

  public Lesson updateLesson(Integer lid, Lesson lesson) {

    Lesson current=lessonRepository.findById(lid).get();
    current.setTopics(lesson.getTopics());
    current.setTitle(lesson.getTitle());
    return lessonRepository.save(current);
  }
}
