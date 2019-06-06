package com.example.myapp.models;

public class Widget {
  private Integer id;
  private String name;
  private String type;
  private String text;


// public enum WidgetType {
//    HEADING, LIST,PARAGRAPH,IMAGE,YOUTUBE,HTML;
//  }

  public Widget(Integer id, String name, String type) {
    this.id = id;
    this.name = name;
    this.type = type;
   // this.text = text;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }



}
