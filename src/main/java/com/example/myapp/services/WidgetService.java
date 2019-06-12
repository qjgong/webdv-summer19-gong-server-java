package com.example.myapp.services;

import com.example.myapp.models.Widget;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class WidgetService {
  private List<Widget> widgets;

  public WidgetService() {
    this.widgets = new ArrayList<>(seed());
  }


  public List<Widget> createWidget(Widget widget) {
    widget.setId((new Random()).nextInt());
    this.widgets.add(widget);
    return this.widgets;
  }

  public List<Widget> findAllWidgets() {
    return this.widgets;
  }

  public Widget findWidgetById(Integer wid) {
    return this.widgets.stream().filter(w -> w.getId().equals(wid)).collect(Collectors.toList()).get(0);
  }

  public Widget updateWidget(Integer wid, Widget widget) {
    this.widgets = this.widgets.stream().map(w -> w.getId().equals(wid) ? widget : w).collect(Collectors.toList());
    return this.findWidgetById(wid);
  }

  public List<Widget> deleteWidget(Integer wid) {
    this.widgets = this.widgets.stream().filter(w -> !w.getId().equals(wid)).collect(Collectors.toList());
    return this.widgets;
  }

  public List<Widget> updateOrder(List<Widget> wts){
    this.widgets=wts;
    return this.widgets;
  }

  private List<Widget> seed() {
    List<Widget> widgets = new ArrayList<>();
    Widget heading = new Widget(123, "Widget 1", "HEADING");
    heading.setSize("h1");
    heading.setText("The Document Object Model");
    widgets.add(heading);
    Widget list = new Widget(234, "Widget 2", "LIST");
    list.setItems("Nodes,Attributes,Tag names,IDs,Styles,Classes");
    list.setListType("unordered");
    widgets.add(list);
    Widget paragraph = new Widget(345, "Widget 3", "PARAGRAPH");
    paragraph.setText("This topic introduces the DOM");
    widgets.add(paragraph);
    Widget image = new Widget(456, "Widget 4", "IMAGE");
    image.setSrc("https://picsum.photos/200");
    widgets.add(image);
    Widget link = new Widget(567, "Widget 5", "LINK");
    link.setTitle("The DOM");
    link.setHref("https://en.wikipedia.org/wiki/Document_Object_Model");
    widgets.add(link);
    return widgets;
  }

}
