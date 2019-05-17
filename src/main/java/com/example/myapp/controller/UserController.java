package com.example.myapp.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.models.User;

@RestController
public class UserController {
  static List<User> users = new ArrayList<User>();

  static {
    users.add(new User(123, "alice", "Alice","abc", "FACULTY"));
    users.add(new User(234, "bob", "Bob","Bolivar","FACULTY"));
    users.add(new User(345, "charlie", "Charlie","Garcia","STUDENT"));
    users.add(new User(456, "dan", "Dan","Craig","STUDENT"));
  }
  // CRUD

  // POST - Creating
  @PostMapping("/users")
  public List<User> createUser(@RequestBody User user) {
    users.add(user);
    return users;
  }

  // GET - Reading
  @GetMapping("/users")
  public List<User> findAllUsers() {
    return users;
  }
  // UPDATE - Updating
  // DELETE - Deleting

}
