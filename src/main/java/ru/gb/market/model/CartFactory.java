package ru.gb.market.model;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public class CartFactory {
    @Lookup
    public Cart getCart(){
        return null;
    }
}
