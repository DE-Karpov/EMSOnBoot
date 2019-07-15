package ru.itis.demo.services;

import ru.itis.demo.models.Product;
import ru.itis.demo.models.User;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Product> getProduct(Long productId);

    void deleteProductFromCart(User user, Product product);

    void deleteProductsFromCart(Long cartId);

    Long getAmount(Long cartId, String name);

}
