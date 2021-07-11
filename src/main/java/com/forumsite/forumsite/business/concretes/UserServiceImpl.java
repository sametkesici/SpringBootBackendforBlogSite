package com.forumsite.forumsite.business.concretes;

import com.forumsite.forumsite.business.abstracts.UserService;
import com.forumsite.forumsite.dataaccess.abstracts.UserDao;
import com.forumsite.forumsite.entities.concretes.User;
import com.forumsite.forumsite.entities.dtos.UserRegisterDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserDao userDao;

  private final PasswordEncoder passwordEncoder;

  @Override
  @Transactional
  public User registerUser(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userDao.save(user);
  }

  @Override
  public List<User> getAllUser() {
    return userDao.findAll();
  }

  @Override
  public User getUser(String username) {
    return userDao.findByUsername(username);
  }
}

