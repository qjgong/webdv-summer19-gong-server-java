package com.example.myapp.controller;

import com.example.myapp.models.Widget;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin("*")
public class WidgetController {


  static List<Widget> widgets = new ArrayList<Widget>();

  static {
    Widget heading = new Widget(123, "Widget 1", "HEADING");
    heading.setSize("h1");
    heading.setText("The Document Object Model");
    widgets.add(heading);
    Widget list = new Widget(234, "Widget 2", "LIST");
    list.setItems("Nodes,Attributes,Tag names,IDs,Styles,Classes");
    list.setListType("unordered");
    widgets.add(list);
    Widget paragraph=new Widget(345, "Widget 3", "PARAGRAPH");
    paragraph.setText("This topic introduces the DOM");
    widgets.add(paragraph);
    Widget image=new Widget(456, "Widget 4", "IMAGE");
    image.setSrc("https://picsum.photos/200");
    widgets.add(image);
    Widget link = new Widget(567,"Widget 5", "LINK");
    link.setTitle("The DOM");
    link.setHerf("https://en.wikipedia.org/wiki/Document_Object_Model");
    widgets.add(link);

  }

  @PostMapping("/api/widgets")
  public List<Widget> createWidget(@RequestBody Widget widget) {
    widget.setId((new Random()).nextInt());
    widgets.add(widget);
    return widgets;
  }

  @GetMapping("/api/widgets")
  public List<Widget> findAllWidgets() {
    return widgets;
  }

  @GetMapping("/api/widgets/{widgetId}")
  public Widget findWidgetById(@PathVariable("widgetId") Integer wid) {
    for (Widget w : widgets) {
      if (w.getId().equals(wid))
        return w;
    }
    return null;
  }

  @PutMapping("/api/widgets/{widgetId}")
  public Widget updateWidget(
          @PathVariable("widgetId") Integer wid,
          @RequestBody Widget newWidget) {
    for (Widget w : widgets) {
      if (w.getId().equals(wid)) {
        w.setName(newWidget.getName());
        w.setType(newWidget.getType());
        w.setText(newWidget.getText());
        return w;
      }
    }
    return null;

  }

  @DeleteMapping("/api/widgets/{widgetId}")
  public List<Widget> deleteWidget(@PathVariable("widgetId") Integer wid) {
    widgets.removeIf(w -> w.getId().equals(wid));
    return widgets;
  }
}
