package ru.gb.market.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.market.model.Product;

public interface CardRepository extends JpaRepository<Product, Long> {
}
