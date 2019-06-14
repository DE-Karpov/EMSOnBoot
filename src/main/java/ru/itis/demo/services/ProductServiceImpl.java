package ru.itis.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.demo.models.Product;
import ru.itis.demo.repositories.ProductsRepository;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductsRepository productsRepository;

    @Autowired
    public ProductServiceImpl(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @Override
    public Optional<Product> getProduct(Long product_id) {
        return productsRepository.findById(product_id);
    }

    @Override
    public void deleteProductFromCart(Long cart_id, Long product_id) {
        productsRepository.deleteProductFromCart(cart_id, product_id);
    }

}
