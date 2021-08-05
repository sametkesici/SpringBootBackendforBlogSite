package com.forumsite.forumsite.dataaccess.abstracts;

import com.forumsite.forumsite.entities.concretes.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDao extends JpaRepository<Comment,Long> {}
