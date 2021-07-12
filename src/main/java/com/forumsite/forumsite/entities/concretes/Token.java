package com.forumsite.forumsite.entities.concretes;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Token {

  @Id
  private String token;

  @ManyToOne
  private User user;

}
