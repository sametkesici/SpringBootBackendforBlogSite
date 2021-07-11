package com.forumsite.forumsite.business.concretes;

import com.forumsite.forumsite.business.abstracts.AuthService;
import com.forumsite.forumsite.business.abstracts.UserService;
import com.forumsite.forumsite.dataaccess.abstracts.UserDao;
import com.forumsite.forumsite.entities.concretes.User;
import com.forumsite.forumsite.entities.dtos.UserLoginDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.SignatureAlgorithm;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

  private final UserService userService;

  private final PasswordEncoder passwordEncoder;

  private final UserDao userDao;

  @Override
  public User authenticate(UserLoginDto userLoginDto) {
    User inDB = userService.getUser(userLoginDto.getUsername());
    boolean matches = passwordEncoder.matches(userLoginDto.getPassword(), inDB.getPassword());
    if (matches) {
      throw new IllegalArgumentException("password is false");
    }
    String token = Jwts.builder().setSubject("" + inDB.getId()).signWith(SignatureAlgorithm.HS512, "my-app-secret").compact();
    inDB.setToken(token);
    return inDB;
  }

  @Override
  @Transactional
  public UserDetails getUserDetails(String token) {
    JwtParser parser = Jwts.parser().setSigningKey("my-app-secret");
    parser.parse(token);
    Claims claims = parser.parseClaimsJws(token).getBody();
    int userId = Integer.parseInt(claims.getSubject());
    User user = userDao.getById(userId);
    User actualUser = (User)((HibernateProxy)user).getHibernateLazyInitializer().getImplementation();
    return actualUser;
  }
}