package ru.gb.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.market.model.Categories;
import ru.gb.market.repositories.CategoriesRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoriesServices {
    private final CategoriesRepository categoriesRepository;

    public Optional<Categories>findByTitle(String title){
        return categoriesRepository.findByTitle(title);
    }

}
