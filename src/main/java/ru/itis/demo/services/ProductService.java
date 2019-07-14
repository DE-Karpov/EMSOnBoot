package ru.itis.demo.services;

import ru.itis.demo.models.Product;
import ru.itis.demo.models.User;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Product> getProduct(Long product_id);

    void deleteProductFromCart(User user, Product product);

    void deleteProductsFromCart(Long cart_id);

    Long getAmount(Long cart_id, String name);

}
