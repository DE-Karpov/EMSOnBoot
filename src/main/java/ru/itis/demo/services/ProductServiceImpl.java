package ru.itis.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.demo.models.Product;
import ru.itis.demo.models.User;
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
    public void deleteProductFromCart(User user, Product product) {
        Long counter = productsRepository.getAmount(user.getCart().getId(), product.getId());
        if (counter == 1L) {
            productsRepository.deleteProductFromCart(user.getCart().getId(), product.getId());
        } else {
            counter--;
            productsRepository.updateAmount(counter, user.getCart().getId(), product.getId());
        }
        for (Product product1 : user.getCart().getProducts()){
            if (product1.getName().equals(product.getName())){
                user.getCart().remove(product1);
                break;
            }
        }
    }

    @Override
    public void deleteProductsFromCart(Long cart_id) {
        productsRepository.deleteProductsFromCart(cart_id);
    }

    @Override
    public Long getAmount(Long cart_id, String name) {
        Long productId = productsRepository.findProductIdByName(name);
        return productsRepository.getAmount(cart_id, productId);
    }


}
