package com.forumsite.forumsite.entities.mappers;

import com.forumsite.forumsite.entities.concretes.User;
import com.forumsite.forumsite.entities.dtos.UserLoginDto;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserLoginMapper extends BaseMapper<User,UserLoginDto> {

  UserLoginDto toDto(User user);

  User toEntity(UserLoginDto dto);


}
