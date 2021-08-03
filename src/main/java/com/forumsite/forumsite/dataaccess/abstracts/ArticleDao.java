package com.forumsite.forumsite.dataaccess.abstracts;

import com.forumsite.forumsite.entities.concretes.Article;
import com.forumsite.forumsite.entities.concretes.User;
import com.forumsite.forumsite.entities.dtos.ArticleResponseDto;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleDao extends JpaRepository<Article,Integer> {


  Page<Article> findByUser(User user, Pageable page);

/*@Query("Select new com.forumsite.forumsite.entities.dtos.ArticleResponseDto"
             + "(a.id, a.content, u.username) "
             + "From User u Inner Join u.articles a")
  List<ArticleResponseDto> getArticleWithUserDetails();*/
}
