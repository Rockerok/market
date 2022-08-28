package ru.gb.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.gb.market.dto.CartDto;
import ru.gb.market.dto.ProductDto;
import ru.gb.market.model.Cart;
import ru.gb.market.services.CartService;
import ru.gb.market.services.CategoriesServices;
import ru.gb.market.services.ProductService;

import javax.validation.constraints.Min;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CartController {
    private final ProductService productService;
    private final CategoriesServices categoryService;
    private final CartService cartService;

    @Min(10)
    private int pageSize=10;

//    @GetMapping("/cart")
//    public Cart getCart (@RequestParam Long userId){
//        return cartService.getCart(userId);
//    }


    @GetMapping("/productsCart")
    public Page<CartDto> getCart(@RequestParam Long userId,
                                     @RequestParam (name = "p", defaultValue = "1") @Min(1) int pageIndex,
                                     @RequestParam ("s") @Min(10) int pageSize) {
        if (pageIndex < 1) {
            pageIndex = 1;
        }
        return (Page<CartDto>) cartService.getCart(userId,pageIndex-1,pageSize);
//        return productService.findAll(pageIndex-1,pageSize).map(ProductDto::new);
    }

    @DeleteMapping("/productsCart/delete/{id}")
    public int deleteCardProductById(@PathVariable Long id){
        cartService.deleteCartProductById(id);
        return HttpStatus.OK.value();
    }
}
