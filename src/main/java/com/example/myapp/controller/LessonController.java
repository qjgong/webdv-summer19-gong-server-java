package com.example.myapp.controller;

import com.example.myapp.models.Lesson;
import com.example.myapp.models.Module;
import com.example.myapp.services.LessonService;
import com.example.myapp.services.ModuleService;

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
public class LessonController {
  @Autowired
  LessonService lessonService;
  @Autowired
  ModuleService moduleService;

  @GetMapping("/api/lessons")
  public List<Lesson> findAllLessons() {
    return lessonService.findAllLessons();
  }

  @GetMapping("/api/modules/{mId}/lessons")
  public List<Lesson> findAllLessonsForModule(
          @PathVariable("mId") Integer mId) {
    return lessonService.findAllLessonsForModule(mId);
  }

  @PostMapping("/api/modules/{mId}/lessons")
  public List<Lesson> addLessonToModule(
          @PathVariable("mId") Integer mId,
          @RequestBody Lesson newLesson
  ) {
    Module module = moduleService.findModuleById(mId);
    newLesson.setModule(module);
    lessonService.createLesson(newLesson);
    return lessonService.findAllLessonsForModule(mId);
  }

  @GetMapping("/api/lessons/{lid}")
  public Lesson findLessonById(@PathVariable("lid") Integer id) {
    return lessonService.findLessonById(id);
  }

  @DeleteMapping("/api/lessons/{lId}")
  public void deleteLesson(@PathVariable("lId") Integer id) {
    this.lessonService.deleteLesson(id);
  }

  @PutMapping("/api/lessons/{lid}")
  public Lesson updateLesson(
          @PathVariable("lid") Integer id,
          @RequestBody Lesson lesson) {

    return lessonService.updateLesson(id, lesson);
  }
}

