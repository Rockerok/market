package ru.gb.market.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

//@Entity
//@Table(name = "cart")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Cart implements Serializable {
    public List<Product> productInCart;
    private Long countProduct;
    private Double sumCart;
    private Long userId;
//    private List<CartItem> items;



//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//
//    @Column(name = "title")
//    private String title;
//
//    @Column(name = "price")
//    private int price;
}
