package com.forumsite.forumsite.business.abstracts;

import com.forumsite.forumsite.entities.concretes.Article;
import com.forumsite.forumsite.entities.concretes.User;

public interface ArticleService {

  Article addArticle(Article article, User user);

}
