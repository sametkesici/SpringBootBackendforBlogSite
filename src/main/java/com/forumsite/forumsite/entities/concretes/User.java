package com.forumsite.forumsite.entities.concretes;

import static javax.persistence.FetchType.EAGER;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.forumsite.forumsite.core.annotations.UniqueUsername;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User  {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false , updatable = false)
  private long id;

  @NotNull
  @UniqueUsername
  private String username;

  @NotNull
  private String password;

  @Temporal(TemporalType.TIMESTAMP)
  private Date timestamp;

  @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
  private List<Article> articles;

  @ManyToMany(fetch = EAGER)
  private Collection<Role> roles = new ArrayList<>();


}
