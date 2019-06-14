package com.example.myapp.controller;

import com.example.myapp.models.Lesson;
import com.example.myapp.models.Module;
import com.example.myapp.repositories.LessonRepository;
import com.example.myapp.repositories.ModuleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class LessonController {
  @Autowired
  LessonRepository repository;
  @Autowired
  ModuleRepository moduleRepository;

  @GetMapping("/api/lessons")
  public List<Lesson> findAllLessons() {
    return repository.findAllLessons();
  }

  @GetMapping("/api/modules/{mId}/lessons")
  public List<Lesson> findAllLessonsForModule(
          @PathVariable("cid") Integer mId) {
    return repository.findAllLessonsForModule(mId);
  }

  @PostMapping("/api/modules/{mId}/lessons")
  public List<Lesson> addLessonToModule(
          @PathVariable("mId") Integer mId,
          @RequestBody Lesson newLesson
  ) {
    Module module = moduleRepository.findModuleById(mId);
    newLesson.setModule(module);
    repository.save(newLesson);
    return repository.findAllLessonsForModule(mId);
  }

  @GetMapping("/api/lessons/{lid}")
  public Lesson findLessonById(@PathVariable("lid") Integer id) {
    return repository.findLessonById(id);
  }
}

