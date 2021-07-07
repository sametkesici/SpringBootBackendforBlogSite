package com.forumsite.forumsite.entities.mappers;

import com.forumsite.forumsite.entities.concretes.User;
import com.forumsite.forumsite.entities.dtos.UserDto;
import java.util.List;
import java.util.Optional;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserDto> {

  UserDto toDto(Optional<User> user);

  User toEntity(UserDto dto);

  List<User> toEntity(List<UserDto> dtoList);

  List<UserDto> toDto(List<User> entityList);

}
