package com.forumsite.forumsite.entities.concretes;

import com.forumsite.forumsite.core.annotations.UniqueUsername;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false , updatable = false)
  private int id;

  @NotNull
  @UniqueUsername
  private String username;

  @NotNull
  @Email
  private String email;

  @NotNull
  private String password;

  @Temporal(TemporalType.TIMESTAMP)
  private Date timestamp;

  @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
  private List<Article> articles;

  private String[] roles;

  private String[] authorities;






}
