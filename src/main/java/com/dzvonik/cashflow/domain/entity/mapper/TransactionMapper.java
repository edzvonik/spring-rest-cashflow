package com.dzvonik.cashflow.domain.entity.mapper;

import com.dzvonik.cashflow.domain.entity.Transaction;
import com.dzvonik.cashflow.domain.entity.dto.TransactionDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionMapper {

    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    TransactionDto toDto(Transaction Transaction);

    Transaction toEntity(TransactionDto TransactionDto);
    
}
