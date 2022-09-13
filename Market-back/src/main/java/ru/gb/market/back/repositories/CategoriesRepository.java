package ru.gb.market.back.repositories;

import ru.gb.market.back.model.Categories;
import ru.gb.market.back.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriesRepository extends JpaRepository<Product, Long> {
    Optional<Categories> findByTitle(String title);

    
}
