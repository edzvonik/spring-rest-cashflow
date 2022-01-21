package com.dzvonik.cashflow.domain.entity.mapper;

import com.dzvonik.cashflow.domain.entity.User;
import com.dzvonik.cashflow.domain.entity.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto toDto(User user);

    User toEntity(UserDto userDto);

}

