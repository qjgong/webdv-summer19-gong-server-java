package com.example.myapp.controller;

import com.example.myapp.models.Course;
import com.example.myapp.models.Module;
import com.example.myapp.repositories.CourseRepository;
import com.example.myapp.repositories.ModuleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class ModuleController {
  @Autowired
  ModuleRepository repository;
  @Autowired
  CourseRepository courseRepository;

  @GetMapping("/api/modules")
  public List<Module> findAllModules(){
    return repository.findAllModules();
  }
  @GetMapping("/api/courses/{cid}/modules")
  public List<Module> findAllModulesForCourse(
          @PathVariable("cid") Integer courseId) {
    return repository.findAllModulesForCourse(courseId);
  }

  @PostMapping("/api/courses/{cid}/modules")
  public List<Module> addModuleToCourse(
          @PathVariable("cid") Integer courseId,
          @RequestBody Module newModule
  ) {
    Course course = courseRepository.findCourseById(courseId);
    newModule.setCourse(course);
    repository.save(newModule);
    return repository.findAllModulesForCourse(courseId);
  }

  @GetMapping("/api/modules/{mid}")
  public Module findModuleById(@PathVariable("mid") Integer id) {
    return repository.findModuleById(id);
  }
}
