package com.forumsite.forumsite.api.controllers;



import com.forumsite.forumsite.core.responses.ErrorDataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.forumsite.forumsite.business.abstracts.AuthService;
import com.forumsite.forumsite.core.responses.DataResponse;
import com.forumsite.forumsite.core.responses.SuccessDataResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/1.0")
public class AuthController {

  private final AuthService authService;

  @GetMapping("/token/refresh")
  public DataResponse<Map<String, String>> refreshToken(HttpServletRequest request, HttpServletResponse response)
  {
    if (authService.refreshToken(request, response).size() > 1) {
      return new SuccessDataResponse<>(authService.refreshToken(request, response), true, "refresh token is valid");
    } else {
      return new ErrorDataResponse<>(authService.refreshToken(request, response), false, "refresh token is not valid");
    }
  }
}




