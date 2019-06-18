package com.example.myapp.services;

import com.example.myapp.models.Course;
import com.example.myapp.models.Module;
import com.example.myapp.repositories.CourseRepository;
import com.example.myapp.repositories.ModuleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ModuleService {
  @Autowired
  ModuleRepository moduleRepository;
  @Autowired
  CourseRepository courseRepository;

  public void createModule(Module m) {
    // m.setId((new Random()).nextInt());
    moduleRepository.save(m);
  }

  public List<Module> findAllModules() {
    return (List<Module>) moduleRepository.findAll();
  }

  public List<Module> findAllModulesForCourse(Integer cid) {
    Course course = courseRepository.findById(cid).get();
    return course.getModules();
  }

  public Module updateModule(Integer mid, Module module) {

    Module current = moduleRepository.findById(mid).get();
    current.setLessons(module.getLessons());
    current.setTitle(module.getTitle());
    return moduleRepository.save(current);
  }

  public Module findModuleById(Integer id) {
    return moduleRepository.findById(id).get();
  }

  public void deleteModule(Integer mid) {
    Module m = moduleRepository.findById(mid).get();
    moduleRepository.delete(m);
  }
}
