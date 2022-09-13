package ru.gb.market.back.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import ru.gb.market.back.model.Categories;
import ru.gb.market.back.dto.CategoriesDto;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface CategoriesMapper {
    CategoriesDto toDto (Categories model);
    Categories toModel (CategoriesDto dto);
}
