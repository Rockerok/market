package ru.gb.market.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.gb.market.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByPriceBetween(int minPrice, int maxPrice);
    List<Product> findProductsByPriceLessThanEqual(int minPrice);
    List<Product> findProductsByPriceGreaterThanEqual(int maxPrice);
}
