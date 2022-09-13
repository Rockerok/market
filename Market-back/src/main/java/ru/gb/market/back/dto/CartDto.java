package ru.gb.market.back.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

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
