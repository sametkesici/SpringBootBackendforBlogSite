package com.forumsite.forumsite;

import com.forumsite.forumsite.business.abstracts.UserService;
import com.forumsite.forumsite.entities.concretes.Role;
import com.forumsite.forumsite.entities.concretes.User;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class ForumsiteApplication {

  public static void main(String[] args) {
    SpringApplication.run(ForumsiteApplication.class, args);
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
};

