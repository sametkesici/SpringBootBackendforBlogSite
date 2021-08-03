package com.forumsite.forumsite.api.controllers;

import com.forumsite.forumsite.business.abstracts.ArticleService;
import com.forumsite.forumsite.core.responses.DataResponse;
import com.forumsite.forumsite.core.responses.Response;
import com.forumsite.forumsite.core.responses.SuccessDataResponse;
import com.forumsite.forumsite.core.responses.SuccessResponse;
import com.forumsite.forumsite.entities.concretes.Article;
import com.forumsite.forumsite.entities.dtos.ArticleResponseDto;
import com.forumsite.forumsite.entities.dtos.ArticleSaveDto;
import com.forumsite.forumsite.entities.mappers.ArticleResponseMapper;
import com.forumsite.forumsite.entities.mappers.ArticleSaveMapper;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1.0/articles")
@RequiredArgsConstructor
@Slf4j
public class ArticleController {

  private final ArticleService articleService;

  private final ArticleSaveMapper articleSaveMapper;

  private final ArticleResponseMapper articleResponseMapper;

  @PostMapping("/add-article")
  @Transactional
  public Response addArticle(@Valid @RequestBody ArticleSaveDto articleSaveDto) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    log.info((String) auth.getPrincipal());
    articleService.addArticle(articleSaveMapper.toEntity(articleSaveDto), (String) auth.getPrincipal());
    return new SuccessResponse(true, "article successfully added");
  }

  @GetMapping("/get-all-articles")
  public DataResponse<List<ArticleResponseDto>> getAllArticles()
  {
    return new SuccessDataResponse<>(articleResponseMapper.toDto(articleService.getAllArticles()),true,"get all articles successfully");
  }

  @GetMapping("/users-{username}-articles")
  public DataResponse<Page<ArticleResponseDto>> getArticlesOfUser(@PathVariable String username, @PageableDefault(sort = "id", direction = Direction.DESC)
      Pageable page){
    return new SuccessDataResponse<>(articleService.getArticlesOfUser(username,page).map(articleResponseMapper::toDto) , true , "pageable articles of user");
  }

  /*@GetMapping("/get-articles")
  public DataResponse<List<ArticleResponseDto>> getArticles()
  {
    return new SuccessDataResponse<>(articleService.getArticles(),true,"get all articles successfully");
  }*/




}
