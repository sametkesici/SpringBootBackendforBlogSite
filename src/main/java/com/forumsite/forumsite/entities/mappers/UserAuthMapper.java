package com.forumsite.forumsite.entities.mappers;

import com.forumsite.forumsite.entities.concretes.User;
import com.forumsite.forumsite.entities.dtos.AuthDto;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserAuthMapper extends BaseMapper<User,AuthDto> {

  AuthDto toDto(User user);

  User toEntity(AuthDto dto);

}
