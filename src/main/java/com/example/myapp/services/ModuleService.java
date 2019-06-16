package com.example.myapp.services;

import com.example.myapp.models.Module;
import com.example.myapp.repositories.ModuleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;


@Service
public class ModuleService {
  @Autowired
  ModuleRepository moduleRepository;

  public void createModule(Module m) {
    m.setId((new Random()).nextInt());
    moduleRepository.save(m);
  }

  public List<Module> findAllModules(){
   return  moduleRepository.findAllModules();
  }
  public List<Module> findAllModulesForCourse(Integer cid){
    return moduleRepository.findAllModulesForCourse(cid);
  }

  public Module findModuleById(Integer id){
    return moduleRepository.findModuleById(id);
  }

}
