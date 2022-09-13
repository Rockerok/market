package ru.gb.market.back.services;

import lombok.RequiredArgsConstructor;
import ru.gb.market.back.model.Categories;
import ru.gb.market.back.repositories.CategoriesRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriesServices {
    private final CategoriesRepository categoriesRepository;

    public Optional<Categories>findByTitle(String title){
        return categoriesRepository.findByTitle(title);
    }

}
