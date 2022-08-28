package ru.gb.market.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gb.market.model.Product;

@Data
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String title;
    private Double price;
    private String categoriesTitle;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
        this.categoriesTitle = product.getCategories().getTitle();
    }
}
