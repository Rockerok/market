package ru.gb.market.back.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gb.market.back.model.Categories;


@Data
@NoArgsConstructor
public class CategoriesDto {
    private Long id;
    private String title;
    public CategoriesDto(Categories categories) {
        this.id = categories.getId();
        this.title = categories.getTitle();
    }
}
