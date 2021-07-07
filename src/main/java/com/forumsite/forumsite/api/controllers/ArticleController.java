package com.forumsite.forumsite.api.controllers;

import com.forumsite.forumsite.business.abstracts.ArticleService;
import com.forumsite.forumsite.core.responses.Response;
import com.forumsite.forumsite.core.responses.SuccessResponse;
import com.forumsite.forumsite.entities.concretes.Article;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1.0/articles")
@RequiredArgsConstructor
public class ArticleController {

  private final ArticleService articleService;

  @PostMapping("/add-article")
  public Response addArticle(@Valid @RequestBody Article article) {
    articleService.addArticle(article);
    return new SuccessResponse(true, "article successfully added");
  }
}
