package com.dzvonik.cashflow.domain.entity.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CategoryInfoDto {

    private final Long id;
    private final String title;

}
