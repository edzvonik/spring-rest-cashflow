package com.dzvonik.cashflow.domain.entity.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper( AccountMapper.class );



}

