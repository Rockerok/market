package ru.gb.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.market.dto.ProductDto;
import ru.gb.market.exceptions.ResourceNotFoundException;
import ru.gb.market.model.Categories;
import ru.gb.market.model.Product;
import ru.gb.market.repositories.CardRepository;
import ru.gb.market.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;
    private final ProductRepository productRepository;

    public Page<Product> findAll(int pageIndex, int pageSize) {
        return cardRepository.findAll(PageRequest.of(pageIndex,pageSize));
    }
    public  Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteCardProductById(Long id) {
        cardRepository.deleteById(id);
    }
}
