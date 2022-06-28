package ru.gb.market.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.market.model.Categories;
import ru.gb.market.model.Product;

import java.util.Optional;

public interface CategoriesRepository extends JpaRepository<Product, Long> {
    Optional<Categories> findByTitle(String title);

    
}
