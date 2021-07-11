package com.forumsite.forumsite.business.abstracts;

import com.forumsite.forumsite.entities.concretes.User;
import com.forumsite.forumsite.entities.dtos.UserRegisterDto;
import java.util.List;
import java.util.Optional;

public interface UserService {

  User registerUser(User user);

  List<User> getAllUser();

  User getUser(String username);


}
