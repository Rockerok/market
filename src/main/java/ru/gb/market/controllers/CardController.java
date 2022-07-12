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
public class CardController {
    private final ProductService productService;
    private final CategoriesServices categoryService;

    @Min(10)
    private int pageSize=10;

    @GetMapping("/card")
    public Page<ProductDto> findAll(@RequestParam (name = "p", defaultValue = "1") @Min(1) int pageIndex,
                                    @RequestParam ("s") @Min(10) int pageSize) {
        if (pageIndex < 1) {
            pageIndex = 1;
        }
        return productService.findAll(pageIndex-1,pageSize).map(ProductDto::new);
    }

    @DeleteMapping("/card/delete/{id}")
    public int deleteCardProductById(@PathVariable Long id){
        productService.deleteProductById(id);
        return HttpStatus.OK.value();
    }
}
