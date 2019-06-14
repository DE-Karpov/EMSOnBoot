package ru.itis.demo.services;

import ru.itis.demo.models.Product;

import java.util.Optional;

public interface ProductService {

    Optional<Product> getProduct(Long product_id);

    void deleteProductFromCart(Long cart_id, Long product_id);

}
