package ru.gb.market.back.services;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.gb.market.back.repositories.CartRepository;
import ru.gb.market.back.repositories.ProductRepository;
import ru.gb.market.back.configs.ApplicationConfiguration;
import ru.gb.market.back.model.Cart;
import ru.gb.market.back.model.Product;

import java.util.List;
import java.util.Optional;

//@NoArgsConstructor
@Service
//@RequiredArgsConstructor
public class CartService {
    ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
    private CartRepository cartRepository;
    private ProductRepository productRepository;
    private List<Product> productInCart;
//    private Cart cart;

//    private Cart cart = context.getBean(Cart.class);

    @Cacheable(value = "/productsCart")
    public Cart getCart(Long userId,int pageIndex, int pageSize) {
        Cart cart = new Cart();
        cart.setProductInCart(productInCart);
        return cart;
    }


    public Page<Product> findAll(int pageIndex, int pageSize) {
        return cartRepository.findAll(PageRequest.of(pageIndex,pageSize));
    }
    public  Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }


//    public Cart cartAddProduct(Product product) {
//        cart.productInCart.add(product);
//        cart.setCountProduct(+1L);
//        cart.setSumCart(cart.getCountProduct() * product.getPrice());
//        return cart;
//    }
//
//    public void deleteCartProductById(Long id) {
//        try {
//            cart.productInCart.remove(id);
//        } catch (IndexOutOfBoundsException iobe){
//            System.out.println("Product not delete from Cart");
//        }
//    }

}
