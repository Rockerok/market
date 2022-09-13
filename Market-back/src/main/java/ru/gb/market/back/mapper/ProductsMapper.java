package ru.gb.market.back.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import ru.gb.market.back.dto.ProductDto;
import ru.gb.market.back.model.Product;

@Mapper(componentModel = "spring",injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductsMapper {
    ProductDto toDto (Product model);
    Product toModel (ProductDto dto);
}
