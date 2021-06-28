package com.forumsite.forumsite.business.abstracts;

import com.forumsite.forumsite.entities.concretes.User;
import java.util.List;

public interface UserService {

  User addUser(User user);

  List<User> getAllUser();

  User getUser(String username);


}
