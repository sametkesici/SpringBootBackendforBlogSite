package com.forumsite.forumsite.dataaccess.abstracts;

import com.forumsite.forumsite.entities.concretes.Role;
import com.google.common.math.LongMath;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {

  Role findByName(String name);

}
