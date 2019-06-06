package com.example.myapp.controller;

import com.example.myapp.models.Widget;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin()
public class WidgetController {


  static List<Widget> widgets = new ArrayList<Widget>();

  static {
    widgets.add(new Widget(123, "Widget 1", "HEADING"));
    widgets.add(new Widget(234, "Widget 2", "LIST"));
    widgets.add(new Widget(345, "Widget 3", "PARAGRAPH"));
    widgets.add(new Widget(456, "Widget 4", "IMAGE"));

  }

  @PostMapping("/api/widgets")
  public List<Widget> createWidget(@RequestBody Widget widget) {
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
        return w;
      }
    }
    return null;
  }

  @DeleteMapping("/api/widgets/{widgetId}")
  public void deleteWidget(@PathVariable("widgetId") Integer wid) {
    widgets.removeIf(w -> w.getId().equals(wid));
  }
}
