package ru.gb.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.gb.market.configs.ApplicationConfiguration;
import ru.gb.market.model.Cart;
import ru.gb.market.model.Product;
import ru.gb.market.repositories.CartRepository;
import ru.gb.market.repositories.ProductRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {
    ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    Cart cart = context.getBean(Cart.class);

    public Page<Product> findAll(int pageIndex, int pageSize) {
        return cartRepository.findAll(PageRequest.of(pageIndex,pageSize));
    }
    public  Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    public void cartAddProduct(Product product) {
        cart.setProductCart(product);
    }

    public void deleteCartProductById(Long id) {
        cart.setRemoveProd(id);
//        cartRepository.deleteById(id);
    }
}
