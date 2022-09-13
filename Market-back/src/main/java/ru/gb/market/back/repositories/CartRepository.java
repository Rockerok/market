package ru.gb.market.back.repositories;

import ru.gb.market.back.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Product, Long> {
}
