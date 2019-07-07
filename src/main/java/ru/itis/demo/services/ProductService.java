package ru.itis.demo.services;

import ru.itis.demo.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Product> getProduct(Long product_id);

    void deleteProductFromCart(Long cart_id, Long product_id);

    void deleteProductsFromCart(Long cart_id);

}
