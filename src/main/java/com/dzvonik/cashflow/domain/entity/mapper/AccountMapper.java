package com.dzvonik.cashflow.domain.entity.mapper;

import com.dzvonik.cashflow.domain.entity.Account;
import com.dzvonik.cashflow.domain.entity.dto.AccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    AccountDto toDto(Account account);

    Account toEntity(AccountDto accountDto);

}
