package com.forumsite.forumsite.business.abstracts;

import com.forumsite.forumsite.entities.concretes.Role;
import com.forumsite.forumsite.entities.concretes.User;
import java.util.List;

public interface UserService {

  User registerUser(User user);

  List<User> getAllUser();

  User getUser(String username);

  Role saveRole(Role role);

  void addRoleToUser(String username, String roleName);
}
