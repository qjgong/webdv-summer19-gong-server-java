package com.example.myapp.controller;

import com.example.myapp.models.Course;
import com.example.myapp.models.Module;
import com.example.myapp.services.CourseService;
import com.example.myapp.services.ModuleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class ModuleController {
  @Autowired
  ModuleService moduleService;
  @Autowired
  CourseService courseService;


  @GetMapping("/api/modules")
  public List<Module> findAllModules(){
    return moduleService.findAllModules();
  }
  @GetMapping("/api/courses/{cid}/modules")
  public List<Module> findAllModulesForCourse(
          @PathVariable("cid") Integer courseId) {
    return moduleService.findAllModulesForCourse(courseId);
  }

  @PostMapping("/api/courses/{cid}/modules")
  public List<Module> addModuleToCourse(
          @PathVariable("cid") Integer courseId,
          @RequestBody Module newModule
  ) {
    Course course = courseService.findCourseById(courseId);
   List<Module> modules=course.getModules();
   modules.add(newModule);

    return moduleService.findAllModulesForCourse(courseId);
  }

  @GetMapping("/api/modules/{mid}")
  public Module findModuleById(@PathVariable("mid") Integer id) {
    return moduleService.findModuleById(id);
  }
}
