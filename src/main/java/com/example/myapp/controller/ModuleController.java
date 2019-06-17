package com.example.myapp.controller;

import com.example.myapp.models.Course;
import com.example.myapp.models.Module;
import com.example.myapp.services.CourseService;
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
public class ModuleController {
  @Autowired
  ModuleService moduleService;
  @Autowired
  CourseService courseService;

  @PostMapping("/api/modules")
  public void createModule(
          @RequestBody Module m) {
    moduleService.createModule(m);
  }
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
 newModule.setCourse(course);
 moduleService.createModule(newModule);

    return moduleService.findAllModulesForCourse(courseId);
  }

  @PutMapping("/api/modules/{mid}")
  public Module updateModule(
          @PathVariable("mid") Integer id,
          @RequestBody Module module) {

    return moduleService.updateModule(id, module);
  }

  @GetMapping("/api/modules/{mid}")
  public Module findModuleById(@PathVariable("mid") Integer id) {
    return moduleService.findModuleById(id);
  }

  @DeleteMapping("/api/modules/{mId}")
  public void deleteModule(@PathVariable("mId") @RequestBody Integer id) {
    this.moduleService.deleteModule(id);
  }
}
