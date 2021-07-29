package com.forumsite.forumsite.business.concretes;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.forumsite.forumsite.business.abstracts.AuthService;
import com.forumsite.forumsite.business.abstracts.UserService;
import com.forumsite.forumsite.core.responses.DataResponse;
import com.forumsite.forumsite.entities.concretes.Role;
import com.forumsite.forumsite.entities.concretes.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

  private final UserService userService;

  @Override
  public Map<String, String> refreshToken(HttpServletRequest request, HttpServletResponse response) {
    String authorizationHeader = request.getHeader(AUTHORIZATION);
    if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
      try {
        String refresh_token = authorizationHeader.substring("Bearer ".length());
        Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(refresh_token);
        String username = decodedJWT.getSubject();
        User user = userService.getUser(username);
        String access_token = JWT
            .create()
            .withSubject(user.getUsername())
            .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
            .withIssuer(request.getRequestURL().toString())
            .withClaim("roles", user.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
            .sign(algorithm);

        String new_refresh_token = JWT
            .create()
            .withSubject(user.getUsername())
            .withExpiresAt(new Date(System.currentTimeMillis() + 30 * 60 * 1000))
            .withIssuer(request.getRequestURL().toString())
            .sign(algorithm);

        Map<String, String> tokens = new HashMap<>();
        tokens.put("access_token", access_token);
        tokens.put("refresh_token", new_refresh_token);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        return tokens;
      } catch (Exception exception) {
        response.setHeader("error", exception.getMessage());
        response.setStatus(FORBIDDEN.value());
        Map<String, String> error = new HashMap<>();
        error.put("error_message", exception.getMessage());
        response.setContentType(MimeTypeUtils.APPLICATION_JSON_VALUE);
        return error;
      }
    } else {
      response.setHeader("error", "refresh token is missing");
      response.setStatus(FORBIDDEN.value());
      Map<String, String> errorRefreshToken = new HashMap<>();
      errorRefreshToken.put("error_message", "refresh token is missing");
      return errorRefreshToken;
    }
  }
}

