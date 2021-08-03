package com.forumsite.forumsite.entities.mappers;

import com.forumsite.forumsite.entities.concretes.Article;
import com.forumsite.forumsite.entities.dtos.ArticleSaveDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArticleSaveMapper extends BaseMapper<Article, ArticleSaveDto>{


    ArticleSaveDto toDto(Article article);

    Article toEntity(ArticleSaveDto articleDto);

}
