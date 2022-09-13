package ru.gb.market.back.repositories;

import ru.gb.market.back.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByPriceBetween(int minPrice, int maxPrice);
    List<Product> findProductsByPriceLessThanEqual(int minPrice);
    List<Product> findProductsByPriceGreaterThanEqual(int maxPrice);

}
