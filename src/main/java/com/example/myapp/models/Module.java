package com.example.myapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Module {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String title;
  @OneToMany(mappedBy = "module",cascade = CascadeType.REMOVE)
  //@JsonIgnore
  private List<Lesson> lessons = new ArrayList<>();

  public Module(String title) {
    this.title = title;
  }

  public Module() {
  }

  @ManyToOne
  @JsonIgnore
  private Course course;


  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
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

  public List<Lesson> getLessons() {
    return lessons;
  }

  public void setLessons(List<Lesson> lessons) {
    this.lessons = lessons;
  }
}
