package com.forumsite.forumsite.entities.mappers;

import com.forumsite.forumsite.business.abstracts.UserService;
import com.forumsite.forumsite.entities.concretes.Article;
import com.forumsite.forumsite.entities.concretes.User;
import com.forumsite.forumsite.entities.dtos.ArticleResponseDto;
import com.forumsite.forumsite.entities.dtos.UserDto;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = UserMapper.class)
public interface ArticleResponseMapper extends BaseMapper<Article, ArticleResponseDto> {

  ArticleResponseDto toDto(Article article);

  Article toEntity(ArticleResponseDto articleResponseDto);

  List<Article> toEntity(List<ArticleResponseDto> dtoList);

  List<ArticleResponseDto> toDto(List<Article> entityList);



}
