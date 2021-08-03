package com.forumsite.forumsite.business.concretes;

import com.forumsite.forumsite.business.abstracts.ArticleService;
import com.forumsite.forumsite.business.abstracts.UserService;
import com.forumsite.forumsite.dataaccess.abstracts.ArticleDao;
import com.forumsite.forumsite.entities.concretes.Article;
import com.forumsite.forumsite.entities.concretes.User;
import com.forumsite.forumsite.entities.dtos.ArticleResponseDto;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

  private final ArticleDao articleDao;

  private final UserService userService;

  @Override
  @Transactional
  public void addArticle(Article article, String username) {

    article.setUser(userService.getUser(username));
    article.setTimestamp(new Date());
    articleDao.save(article);
  }

  @Override
  public List<Article> getAllArticles() {
    return articleDao.findAll();
  }

  public Page<Article> getArticlesOfUser(String username, Pageable page) {
    return articleDao.findByUser(userService.getUser(username), page);
  }

  /*@Override
  public List<ArticleResponseDto> getArticles() {
    return articleDao.getArticleWithUserDetails();
  }*/
}
