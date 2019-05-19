package com.example.myapp.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
  @PostMapping("/api/users")
  public void createUser(@RequestBody User user) {
    long generatedLong = new Random().nextInt();
    user.setId(generatedLong);
    users.add(user);

  }

  // GET - Reading
  @GetMapping("/api/users")
  public List<User> findAllUsers() {
    return users;
  }


  @GetMapping("/api/users/{userId}")
  public User findUserById(@PathVariable("userId") long id) {

    for (User user : users) {
      if (user.getId() == id) {
        return user;
      }
    }
    return null;
  }


  // DELETE - Deleting
  @DeleteMapping("/api/users/{userId}")
  public void deleteUser(@PathVariable("userId") @RequestBody long id) {
    users.removeIf(x -> x.getId() == id);
  }

  // UPDATE - Updating
  @PutMapping("/api/users/{userId}")
  public void updateUser(@PathVariable("userId") long id, @RequestBody User user) {

    for (User currentUser : users) {

      if (currentUser.getId() == id) {
        currentUser.setUsername(user.getUsername());
        currentUser.setRole(user.getRole());
        currentUser.setFirstName(user.getFirstName());
        currentUser.setLastName(user.getLastName());
        currentUser.setPassword(user.getPassword());
      }
    }
  }

  @PostMapping(value = "/api/users/select/")
  public List<User> searchUser(@RequestBody User user) {
    List<User> selectedUsers = new ArrayList<User>();
    selectedUsers.addAll(users);
    if (!user.getFirstName().isEmpty()) {
      for (User element : selectedUsers) {
        if (!element.getFirstName().equals(user.getFirstName()))
          selectedUsers.remove(element);
      }
    }
    if (!user.getLastName().isEmpty()) {
      for (User element : selectedUsers) {
        if (!element.getLastName().equals(user.getLastName()))
          selectedUsers.remove(element);
      }
    }

    if (!user.getRole().isEmpty()) {
      for (User element : selectedUsers) {
        if (!element.getRole().equals(user.getRole()))
          selectedUsers.remove(element);
      }
    }
    if (!user.getUsername().isEmpty()) {
      for (User element : selectedUsers) {
        if (!element.getUsername().equals(user.getUsername()))
          selectedUsers.remove(element);
      }
    }
    return selectedUsers;
  }

}
