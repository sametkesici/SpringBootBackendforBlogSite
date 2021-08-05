package com.forumsite.forumsite.api.controllers;

import com.forumsite.forumsite.business.abstracts.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1.0/comments")
@RequiredArgsConstructor
public class CommentController {

  private final CommentService commentService;


  


}
