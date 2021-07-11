package com.forumsite.forumsite.business.concretes;

import com.forumsite.forumsite.core.configuration.security.ForumUserDetails;
import com.forumsite.forumsite.dataaccess.abstracts.UserDao;
import com.forumsite.forumsite.entities.concretes.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserAuthServiceImpl implements UserDetailsService {

  private final UserDao userDao;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User inDB = userDao.findByUsername(username);
      if(inDB == null){
        throw new UsernameNotFoundException("user not found");
      }
    return new ForumUserDetails(inDB);
  }
}
