package com.forumsite.forumsite.entities.mappers;

import com.forumsite.forumsite.entities.concretes.Article;
import com.forumsite.forumsite.entities.dtos.ArticleDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArticleMapper extends BaseMapper<Article, ArticleDto>{


    ArticleDto toDto(Article article);

    Article toEntity(ArticleDto articleDto);

}
