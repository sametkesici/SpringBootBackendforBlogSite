package com.forumsite.forumsite.business.concretes;

import com.forumsite.forumsite.business.abstracts.ArticleService;
import com.forumsite.forumsite.dataaccess.abstracts.ArticleDao;
import com.forumsite.forumsite.entities.concretes.Article;
import com.forumsite.forumsite.entities.concretes.User;
import java.util.Date;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

  private final ArticleDao articleDao;

  @Override
  @Transactional
  public Article addArticle(Article article, User user) {

    article.setUser(user);
    article.setTimestamp(new Date());
    return articleDao.save(article);
  }
}
