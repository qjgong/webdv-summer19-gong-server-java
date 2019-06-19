package com.example.myapp.repositories;

import com.example.myapp.models.Module;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ModuleRepository extends CrudRepository<Module, Integer> {
//  @Query("select module from Module module")
//  public List<Module> findAllModules();
//
//  // select module from Module m, Course c where m.course_id = c.id
//  @Query("select module from Module module where module.course.id = :cid")
//  public List<Module> findAllModulesForCourse(@Param("cid") Integer courseId);
//
//  @Query("select module from Module module where module.id = :id")
//  public Module findModuleById(@Param("id") Integer id);
}
