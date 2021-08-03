package com.forumsite.forumsite.entities.dtos;

import com.forumsite.forumsite.entities.concretes.Role;
import com.forumsite.forumsite.entities.concretes.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapping;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleResponseDto {

  private long id;

  private String content;

  private User user;

}
