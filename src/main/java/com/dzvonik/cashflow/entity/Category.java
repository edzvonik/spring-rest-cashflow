package com.dzvonik.cashflow.entity;

import com.dzvonik.cashflow.entity.enums.CategoryTypes;
import lombok.Getter;
import lombok.Setter;

public class Category {
    @Getter @Setter int categoryId;
    @Getter @Setter String title;
    @Getter @Setter CategoryTypes type;
}
