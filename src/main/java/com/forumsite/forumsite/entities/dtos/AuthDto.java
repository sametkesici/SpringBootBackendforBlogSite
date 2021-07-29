package com.forumsite.forumsite.entities.dtos;

import java.util.Date;
import lombok.Data;

@Data
public class AuthDto {

  private String username;

  private Date timestamp;

}
