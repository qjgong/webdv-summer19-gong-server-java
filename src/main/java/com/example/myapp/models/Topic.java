package com.example.myapp.models;

import java.util.ArrayList;
import java.util.List;

public class Topic {
  private Integer id;
  private String title;
  private List<Widget> widgets = new ArrayList<>();

  public Integer getId() {
    return id;
  }

  public Topic(Integer id, String title) {
    this.id = id;
    this.title = title;
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

  public List<Widget> getWidgets() {
    return widgets;
  }

  public void setWidgets(List<Widget> widgets) {
    this.widgets = widgets;
  }
}
