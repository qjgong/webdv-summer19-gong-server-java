package com.example.myapp.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.models.User;

@RestController
public class UserController {
  static List<User> users = new ArrayList<User>();

  static {
    users.add(new User(123, "alice", "faggaf", "Alice", "abc", "FACULTY"));
    users.add(new User(234, "bob", "faggvffvaf", "Bob", "Bolivar", "FACULTY"));
    users.add(new User(345, "charlie", "fgaf", "Charlie", "Garcia", "STUDENT"));
    users.add(new User(456, "dan", "fagdfvfvfavbgaf", "Dan", "Craig", "STUDENT"));
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


  @GetMapping("/users/{userId}")
  public User findUserById(@PathVariable("userId") long id) {

    for (User user : users) {
      if (user.getId() == id) {
        return user;
      }
    }
    return null;
  }


  // DELETE - Deleting
  @DeleteMapping("/users/{userId}")
  public List<User> deleteUser(@PathVariable("userId") long id) {
    for (User user : users) {
      if (user.getId() == id) {
        users.remove(user);
      }
    }
    return users;
  }

  // UPDATE - Updating
  @PutMapping("/users/{userId}")
  public List<User> updateUser(@PathVariable("userId") long id, @RequestBody User user) {

    for (User currentUser : users) {

      if (currentUser.getId() == id) {
        currentUser.setUsername(user.getUsername());
        currentUser.setRole(user.getRole());
        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());
        currentUser.setPassword(user.getPassword());
      }
    }
    return users;
  }
}
