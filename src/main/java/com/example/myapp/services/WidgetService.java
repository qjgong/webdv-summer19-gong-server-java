package com.example.myapp.services;

import com.example.myapp.models.Course;
import com.example.myapp.models.Topic;
import com.example.myapp.models.Widget;
import com.example.myapp.repositories.TopicRepository;
import com.example.myapp.repositories.WidgetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Service
public class WidgetService {
  @Autowired
 WidgetRepository widgetRepository;
  @Autowired
  TopicRepository topicRepository;


  public List<Widget> createWidget(Widget widget) {
   // widget.setId((new Random()).nextInt());
   widgetRepository.save(widget);
   return widgetRepository.findAllWidgets();
  }

  public List<Widget> findAllWidgets() {
    return widgetRepository.findAllWidgets();
  }

  public Widget findWidgetById(Integer wid) {
    return widgetRepository.findWidgetById(wid);
  }

  public Widget updateWidget(Integer wid, Widget widget) {
    Widget current = widgetRepository.findWidgetById(wid);
    current.setName(widget.getName());
    current.setType(widget.getType());
    current.setTitle(widget.getTitle());
    current.setListType(widget.getListType());
    current.setSrc(widget.getSrc());
    current.setHref(widget.getHref());
    current.setSize(widget.getSize());
    current.setItems(widget.getItems());
    current.setText(widget.getText());

    return widgetRepository.save(current);
  }

  public List<Widget> deleteWidget(Integer wid) {
    Widget current = widgetRepository.findWidgetById(wid);
    widgetRepository.delete(current);
    return widgetRepository.findAllWidgets();
  }

  public List<Widget> updateOrder(List<Widget> wts, Integer topicId){


    Topic topic=topicRepository.findTopicById(topicId);
   for(Widget w:wts){
     w.setTopic(topic);
     widgetRepository.save(w);
   }
    List<Widget> widgets=widgetRepository.findAllWidgetsForTopic(topicId);
    return widgetRepository.findAllWidgetsForTopic(topicId);

  }

  public List<Widget> findAllWidgetsForTopic(Integer tid){
    return widgetRepository.findAllWidgetsForTopic(tid);
  }



//  private List<Widget> seed() {
//    List<Widget> widgets = new ArrayList<>();
//    Widget heading = new Widget(123, "Widget 1", "HEADING");
//    heading.setSize("h1");
//    heading.setText("The Document Object Model");
//    widgets.add(heading);
//    Widget list = new Widget(234, "Widget 2", "LIST");
//    list.setItems("Nodes,Attributes,Tag names,IDs,Styles,Classes");
//    list.setListType("unordered");
//    widgets.add(list);
//    Widget paragraph = new Widget(345, "Widget 3", "PARAGRAPH");
//    paragraph.setText("This topic introduces the DOM");
//    widgets.add(paragraph);
//    Widget image = new Widget(456, "Widget 4", "IMAGE");
//    image.setSrc("https://picsum.photos/200");
//    widgets.add(image);
//    Widget link = new Widget(567, "Widget 5", "LINK");
//    link.setTitle("The DOM");
//    link.setHref("https://en.wikipedia.org/wiki/Document_Object_Model");
//    widgets.add(link);
//    return widgets;
//  }

}
