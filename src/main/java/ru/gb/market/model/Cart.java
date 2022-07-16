package ru.gb.market.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Entity
//@Table(name = "cart")
//@Data
@NoArgsConstructor
@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Cart {
    private CartFactory cartFactory;
    private List<Product> productCart;

    public List<Product> getCart() {
        return productCart;
    }
    public void setProductCart(Product product) {
        productCart.add(product);
    }

    @Autowired
    public Cart(CartFactory cartFactory, List<Product> productCart) {
        productCart = new ArrayList<>();
        this.cartFactory = cartFactory;
        this.productCart = productCart;
    }

    public void setRemoveProd(Long id) {
        try {
            productCart.remove(id);
        } catch (IndexOutOfBoundsException iobe){
            System.out.println("Product not delete from Cart");
        }
    }

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
