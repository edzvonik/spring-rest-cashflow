package com.dzvonik.cashflow.domain.entity.mapper;

import com.dzvonik.cashflow.domain.entity.Category;
import com.dzvonik.cashflow.domain.entity.dto.CategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDto toDto(Category Category);

    Category toEntity(CategoryDto CategoryDto);
    
}
