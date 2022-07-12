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
import ru.gb.market.repositories.CategoriesRepository;
import ru.gb.market.repositories.ProductRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoriesServices categoriesServices;

//    public List<Product> findAll() {
//        return productRepository.findAll();
//    }
    public Page<Product> findAll(int pageIndex, int pageSize) {
        return productRepository.findAll(PageRequest.of(pageIndex,pageSize));
    }
    public  Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProductById(Long id) {
                    productRepository.deleteById(id);
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

    @Transactional
    public void updateProductFromDto(ProductDto productDto){
        Product product = findProductById(productDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Product id = " + productDto.getId() + " not found"));
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        Categories category = categoriesServices.findByTitle(productDto
                        .getCategoriesTitle())
                .orElseThrow(() -> new ResourceNotFoundException("Category title = " + productDto.getCategoriesTitle() + " not found"));
        product.setCategories(category);
    }
}
