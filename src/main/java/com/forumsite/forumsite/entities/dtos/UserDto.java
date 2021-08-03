package com.forumsite.forumsite.entities.dtos;

import com.forumsite.forumsite.entities.concretes.Role;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import lombok.Data;

@Data
public class UserDto {

  private int id;
  private String username;
  private Date timestamp;
  private Collection<Role> roles ;

}
