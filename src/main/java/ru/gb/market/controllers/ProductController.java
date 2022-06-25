package ru.gb.market.controllers;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bind.annotation.Empty;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.gb.market.dto.ProductDto;
import ru.gb.market.model.Product;
import ru.gb.market.services.ProductService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

//    @GetMapping("/products")
//    public List<Product> findAll() {
//        return productService.findAll();
//    }

    // попытка получить список ВСЕх через ДТО
    @GetMapping("/products")
    public List<ProductDto> findAll(@RequestParam(value = "min", required = false) int minPrice,
                                    @RequestParam(value = "max", required = false) int maxPrice, BindingResult bindingResult) {

        List<ProductDto> productDtoList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();

        // реализация только на ноль, вызывает трудности момент как быть, если параметр отсутствует

        if ((minPrice >0) & maxPrice >0) {
            productList = productService.findByPriceBetween(minPrice,maxPrice);
        }
        if (minPrice > 0 & maxPrice == 0){
            productList = productService.findProductsByPriceLessThanEqual (minPrice);
        }
        if (minPrice == 0 & maxPrice >0){
            productList = productService.findProductsByPriceGreaterThanEqual (maxPrice);
        }
        if (minPrice == 0 & maxPrice == 0){
            productList = productService.findAll();
        }

        for (Product p:productList) {
            productDtoList.add(new ProductDto(p));
        }
        return productDtoList;
    }

    @GetMapping("/products/{id}")
    public ProductDto findProductById(@PathVariable Long id){
        return new ProductDto(productService.findProductById(id).get());
    }

    @PostMapping("/products")
    public ProductDto saveProduct(@RequestBody ProductDto productDto){
        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        productService.saveProduct(product);
        return new ProductDto(product);
    }

    @GetMapping("/products/delete/{id}")
    public boolean deleteProductById(@PathVariable Long id){
        return productService.deleteProductById(id);
    }


}
