package ru.gb.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.gb.market.model.Product;
import ru.gb.market.repositories.ProductRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

//    public List<Product> findAll() {
//        return productRepository.findAll();
//    }
    public Page<Product> findAll(int pageIndex, int pageSize) {
        return productRepository.findAll(PageRequest.of(pageIndex,pageSize));
    }
    public  Optional<Product> findProductById(Long id) {
        return Optional.of(productRepository.findById(id).get());
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public boolean deleteProductById(Long id) {
        try {
            Optional<Product> product = Optional.of(productRepository.findById(id).get());
            productRepository.delete(product.get());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Product> findByPriceBetween(int minPrice, int maxPrice) {
        return productRepository.findByPriceBetween(minPrice,maxPrice);
    }

    public List<Product> findProductsByPriceLessThanEqual(int minPrice) {
        return productRepository.findProductsByPriceLessThanEqual(minPrice);
    }

    public List<Product> findProductsByPriceGreaterThanEqual(int maxPrice) {
        return productRepository.findProductsByPriceGreaterThanEqual(maxPrice);
    }
}
