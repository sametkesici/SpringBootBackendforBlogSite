package com.forumsite.forumsite.business.concretes;

import com.forumsite.forumsite.business.abstracts.UserService;
import com.forumsite.forumsite.dataaccess.abstracts.RoleDao;
import com.forumsite.forumsite.dataaccess.abstracts.UserDao;
import com.forumsite.forumsite.entities.concretes.Role;
import com.forumsite.forumsite.entities.concretes.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

  private final UserDao userDao;

  private final RoleDao roleDao;

  private final PasswordEncoder passwordEncoder;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userDao.getByUsername(username);
    if(user == null){
      log.error("user not found");
      throw new UsernameNotFoundException("user not found");
    }else {
      log.info("user found {}" , username);
    }
    Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
    user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
    return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
  }


  @Override
  @Transactional
  public User registerUser(User user) {
    log.info("saving new user to the database");
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    user.setTimestamp(new Date());
    addRoleToUser(user.getUsername(),"ROLE_USER");
    return userDao.save(user);
  }


  @Override
  public List<User> getAllUser() {
    log.info("fetching all users");
    return userDao.findAll();
  }

  @Override
  public User getUser(String username) {
    log.info("fetching user {}" , username);
    return userDao.getByUsername(username);
  }

  @Override
  @Transactional
  public Role saveRole(Role role) {
    log.info("saving new role {} to the database",role.getName());
    return roleDao.save(role);
  }

  @Override
  @Transactional
  public void addRoleToUser(String username, String roleName) {
    log.info("adding role {} to user {} mew role ",roleName,username);
    User user = userDao.getByUsername(username);
    Role role = roleDao.findByName(roleName);
    user.getRoles().add(role);
  }




}

