package com.forumsite.forumsite.core.annotations;

import com.forumsite.forumsite.dataaccess.abstracts.UserDao;
import com.forumsite.forumsite.entities.concretes.User;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername , String> {

  private final UserDao userDao;


  @Override
  public boolean isValid(String username, ConstraintValidatorContext context) {
    User user = userDao.getByUsername(username);
    if(user != null){
      return false;
    }
    return true;
  }
}
