package com.forumsite.forumsite.business.abstracts;

import com.forumsite.forumsite.entities.concretes.User;
import com.forumsite.forumsite.entities.dtos.UserLoginDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthService {

  User authenticate(UserLoginDto userLoginDto);

  UserDetails getUserDetails(String token);

}
