package com.forumsite.forumsite.business.abstracts;

import com.forumsite.forumsite.entities.concretes.Article;
import com.forumsite.forumsite.entities.concretes.User;
import com.forumsite.forumsite.entities.dtos.ArticleResponseDto;
import com.forumsite.forumsite.entities.dtos.ArticleSaveDto;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArticleService {

  void addArticle(Article article, String username);

  List<Article> getAllArticles();

  /*List<ArticleResponseDto> getArticles();*/

  Page<Article> getArticlesOfUser(String username, Pageable page);


}
