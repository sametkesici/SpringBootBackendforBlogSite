package com.forumsite.forumsite.dataaccess.abstracts;

import com.forumsite.forumsite.entities.concretes.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenDao extends JpaRepository<Token, String> {}
