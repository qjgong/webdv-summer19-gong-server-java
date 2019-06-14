package com.example.myapp.models;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Course {
  @Id
  private Integer id;
  private String title;
  private List<Module> modules = new ArrayList<Module>();

  public List<Module> getModules() {
    return modules;
  }

  public void setModules(List<Module> modules) {
    this.modules = modules;
  }

  public Course(Integer id, String title) {
    this.id = id;
    this.title = title;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}