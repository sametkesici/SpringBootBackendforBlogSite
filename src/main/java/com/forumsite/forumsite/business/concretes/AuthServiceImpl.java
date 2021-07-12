package com.forumsite.forumsite.business.concretes;

import com.forumsite.forumsite.business.abstracts.AuthService;
import com.forumsite.forumsite.business.abstracts.UserService;
import com.forumsite.forumsite.dataaccess.abstracts.TokenDao;
import com.forumsite.forumsite.entities.concretes.Token;
import com.forumsite.forumsite.entities.concretes.User;
import com.forumsite.forumsite.entities.dtos.UserLoginDto;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

  private final UserService userService;

  private final PasswordEncoder passwordEncoder;

  private final TokenDao tokenDao;

  @Override
  @Transactional
  public User authenticate(UserLoginDto userLoginDto) {
    Token tokenEntity = new Token();
    User inDB = userService.getUser(userLoginDto.getUsername());
    boolean matches = passwordEncoder.matches(userLoginDto.getPassword(), inDB.getPassword());
    if (matches) {
      throw new IllegalArgumentException("password is false");
    }
    String token = generateRandomToken();
    tokenEntity.setToken(token);
    tokenEntity.setUser(inDB);
    tokenDao.save(tokenEntity);
    return inDB;
  }

  @Override
  @Transactional
  public UserDetails getUserDetails(String token) {
    Optional<Token> optinalToken =  tokenDao.findById(token);
    if(optinalToken.isPresent()){
      return null;
    }
    return optinalToken.get().getUser();
  }

  @Override
  @Transactional
  public void clearToken(String token) {
    tokenDao.deleteById(token);
  }

  public String generateRandomToken(){
    return UUID.randomUUID().toString().replaceAll("-","");
  }

}


