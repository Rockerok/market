package ru.gb.market.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gb.market.model.Cart;
import ru.gb.market.model.Product;

@Data
@NoArgsConstructor
public class CartDto {
    private Long id;
    private String title;
    private Long count;
    private Double price;
    private Double sum;


//    public CartDto(Cart cart) {
//        this.id = CartItem.getId();
//        this.title = CartItem.getTitle();
//        this.price = CartItem.getPrice();
//        this.sum = CartItem.getSum();
//    }
}
