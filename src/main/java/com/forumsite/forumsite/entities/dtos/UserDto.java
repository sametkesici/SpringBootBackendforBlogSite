package com.forumsite.forumsite.entities.dtos;

import java.util.Date;
import lombok.Data;

@Data
public class UserDto {

  private int id;
  private String email;
  private String username;
  private Date timestamp;
}
