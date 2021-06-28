package com.forumsite.forumsite.api.controllers;

import com.forumsite.forumsite.business.abstracts.UserService;
import com.forumsite.forumsite.core.responses.DataResponse;
import com.forumsite.forumsite.core.responses.Response;
import com.forumsite.forumsite.core.responses.SuccessDataResponse;
import com.forumsite.forumsite.core.responses.SuccessResponse;
import com.forumsite.forumsite.entities.concretes.User;
import com.forumsite.forumsite.entities.dtos.UserDto;
import com.forumsite.forumsite.entities.mappers.UserMapper;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api-user")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  private final UserMapper userMapper;

  @PostMapping("add")
  public Response addUser(@Valid @RequestBody User user) {
    userService.addUser(user);
    return new SuccessResponse(true, "successfully added user");
  }

  @GetMapping("getUser")
  public DataResponse<UserDto> getUser(@RequestParam String username) {
    return new SuccessDataResponse<>(userMapper.toDto(userService.getUser(username)), true, "get user");
  }

  @GetMapping("get-all")
  public DataResponse<List<UserDto>> getAllUsers() {
    return new SuccessDataResponse<>(userMapper.toDto(userService.getAllUser()), true, "brough all users");
  }
}
