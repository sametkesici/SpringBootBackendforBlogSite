package com.forumsite.forumsite.entities.mappers;

import com.forumsite.forumsite.entities.concretes.User;
import com.forumsite.forumsite.entities.dtos.UserRegisterDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRegisterMapper extends BaseMapper<User, UserRegisterDto> {

  UserRegisterDto toDto(User user);

  User toEntity(UserRegisterDto userRegisterDto);

}
