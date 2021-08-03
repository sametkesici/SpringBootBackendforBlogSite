package com.forumsite.forumsite.business.concretes;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.forumsite.forumsite.dataaccess.abstracts.RoleDao;
import com.forumsite.forumsite.dataaccess.abstracts.UserDao;
import com.forumsite.forumsite.entities.concretes.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;


@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

  @Mock
  private UserDao userDao;

  @Mock
  private RoleDao roleDao;

  @Mock
  private PasswordEncoder passwordEncoder;

  private UserServiceImpl userServiceImpl;

  @BeforeEach
  void initUseCase() {
    userServiceImpl = new UserServiceImpl(userDao,roleDao,passwordEncoder);
  }

  @Test
  void savedUserHasRegistrationDate() {
    User user = new User();
    //when(userDao.save(user).then(returnsFirstArg());
    User savedUser = userServiceImpl.registerUser(user);
    //assertThat(savedUser.getTimestamp()).isNotNull();
  }

}