package com.forumsite.forumsite.dataaccess.abstracts;

import com.forumsite.forumsite.entities.concretes.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleDao extends JpaRepository<Article,Integer> {}
