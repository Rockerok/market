package ru.gb.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.gb.market.dto.ProductDto;
import ru.gb.market.exceptions.DataValidationException;
import ru.gb.market.exceptions.ResourceNotFoundException;
import ru.gb.market.model.Categories;
import ru.gb.market.model.Product;
import ru.gb.market.services.CategoriesServices;
import ru.gb.market.services.ProductService;

import javax.validation.constraints.Min;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final CategoriesServices categoryService;

    @Min(5)
    private int pageSize=10;

    @GetMapping("/products")
    public Page<ProductDto> findAll(@RequestParam (name = "p", defaultValue = "1") @Min(1) int pageIndex,
                                    @RequestParam ("s") @Min(5) int pageSize) {
        if (pageIndex < 1) {
            pageIndex = 1;
        }
        return productService.findAll(pageIndex-1,pageSize).map(ProductDto::new);
    }

    // попытка получить список ВСЕх через ДТО
//    @GetMapping("/products")
//    public List<ProductDto> findAll(@RequestParam(value = "min", required = false) int minPrice,
//                                    @RequestParam(value = "max", required = false) int maxPrice, BindingResult bindingResult) {
//
//        List<ProductDto> productDtoList = new ArrayList<>();
//        List<Product> productList = new ArrayList<>();
//
//        // реализация только на ноль, вызывает трудности момент как быть, если параметр отсутствует
//        if ((minPrice >0) & maxPrice >0) { productList = productService.findByPriceBetween(minPrice,maxPrice);
//        }
//        if (minPrice > 0 & maxPrice == 0){ productList = productService.findProductsByPriceLessThanEqual (minPrice);
//        }
//        if (minPrice == 0 & maxPrice >0){ productList = productService.findProductsByPriceGreaterThanEqual (maxPrice);
//        }
//        if (minPrice == 0 & maxPrice == 0){ productList = productService.findAll();
//        }
//
//        for (Product p:productList) {
//            productDtoList.add(new ProductDto(p));
//        }
//        return productDtoList;
//    }

    //  http://localhost:8189/market/api/v1/products/{id}
    @GetMapping("/products/{id}")
    public ProductDto findProductById(@PathVariable Long id){
        return new ProductDto(productService
                .findProductById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Product id = "+id+" not found")));
//                .get());
    }

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto saveProduct(@RequestBody @Validated ProductDto productDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            throw new DataValidationException(bindingResult
                    .getAllErrors()
                    .stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.toList()));
        }
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        Categories categories = categoryService.findByTitle(productDto
                    .getCategoriesTitle())
                    .orElseThrow(()-> new ResourceNotFoundException("Category title = "+ productDto.getCategoriesTitle() +" not found"));
        product.setCategories(categories);
        productService.saveProduct(product);
        return new ProductDto(product);
    }

    @DeleteMapping("/products/delete/{id}")
    public int deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
        return HttpStatus.OK.value();
    }
//    @DeleteMapping("/products/delete/{id}")
//    public int deleteProductById(@RequestParam ("id") Long id){
//        return productService.deleteProductById(id);
//    }

    @PutMapping("/products")
    public void updateProduct(@RequestBody ProductDto productDto) {
        productService.updateProductFromDto(productDto);
    }
}
