package com.forumsite.forumsite.api.controllers;

import com.forumsite.forumsite.business.abstracts.AuthService;
import com.forumsite.forumsite.core.responses.DataResponse;
import com.forumsite.forumsite.core.responses.Response;
import com.forumsite.forumsite.core.responses.SuccessDataResponse;
import com.forumsite.forumsite.core.responses.SuccessResponse;
import com.forumsite.forumsite.entities.dtos.AuthDto;
import com.forumsite.forumsite.entities.dtos.UserLoginDto;
import com.forumsite.forumsite.entities.mappers.UserAuthMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/1.0")
public class AuthController {

  private final AuthService authService;

  private final UserAuthMapper userAuthMapper;

  @PostMapping("/login")
  DataResponse<AuthDto> handleAuthentication(@RequestBody UserLoginDto userLoginDto) {
    return new SuccessDataResponse<>(userAuthMapper.toDto(authService.authenticate(userLoginDto)),true,"auth response");
  }


  @PostMapping("/logout")
  Response handleLogOut(@RequestHeader(name = "Authorization") String authorization){
    String token = authorization.substring(7);
    authService.clearToken(token);
    return new SuccessResponse(true,"logout success");
  }

}

