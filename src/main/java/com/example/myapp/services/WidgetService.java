package com.example.myapp.services;

import com.example.myapp.models.Widget;
import com.example.myapp.repositories.TopicRepository;
import com.example.myapp.repositories.WidgetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WidgetService {
  @Autowired
 WidgetRepository widgetRepository;
  @Autowired
  TopicRepository topicRepository;


  public List<Widget> createWidget(Widget widget) {
   // widget.setId((new Random()).nextInt());
   widgetRepository.save(widget);
   return (List<Widget>)widgetRepository.findAll();
  }

  public List<Widget> findAllWidgets() {
    return (List<Widget>)widgetRepository.findAll();
  }

  public Widget findWidgetById(Integer wid) {
    return widgetRepository.findById(wid).get();
  }

  public Widget updateWidget(Integer wid, Widget widget) {
    Widget current = widgetRepository.findById(wid).get();
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
    Widget current = widgetRepository.findById(wid).get();
    widgetRepository.delete(current);
    return(List<Widget>) widgetRepository.findAll();
  }

  public List<Widget> updateOrder(List<Widget> wts, Integer topicId){

    return wts;
  }

  public List<Widget> findAllWidgetsForTopic(Integer tid){
    return topicRepository.findById(tid).get().getWidgets();
  }


}
