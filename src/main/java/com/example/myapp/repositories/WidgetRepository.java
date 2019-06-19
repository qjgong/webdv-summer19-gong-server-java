package com.example.myapp.repositories;

import com.example.myapp.models.Widget;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface WidgetRepository extends CrudRepository<Widget, Integer> {
//  @Query("select widget from Widget widget")
//  public List<Widget> findAllWidgets();
//
//  @Query("select widget from Widget widget where widget.topic.id = :tid")
//  public List<Widget> findAllWidgetsForTopic(@Param("tid") Integer tid);
//
//
//  @Query("select widget from Widget widget where widget.id=:wid")
//  public Widget findWidgetById(@Param("wid") Integer id);
}
