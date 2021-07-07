package com.forumsite.forumsite.business.concretes;

import com.forumsite.forumsite.business.abstracts.UserService;
import com.forumsite.forumsite.dataaccess.abstracts.UserDao;
import com.forumsite.forumsite.entities.concretes.User;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserDao userDao;

  @Override
  @Transactional
  public User addUser(User user) {
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

