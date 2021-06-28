package com.forumsite.forumsite.entities.mappers;

import java.util.List;
import org.mapstruct.Mapper;

public interface BaseMapper<T, G> {

  T toEntity(G g);

  G toDto(T t);

  List<T> toEntity(List<G> gList);

  List<G> toDto(List<T> tList);


}
