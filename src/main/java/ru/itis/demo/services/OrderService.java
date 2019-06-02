package ru.itis.demo.services;

import ru.itis.demo.models.Address;
import ru.itis.demo.models.Cart;
import ru.itis.demo.models.Product;
import ru.itis.demo.models.User;

import java.util.List;

public interface OrderService {
    List<Product> findOrders(Long userId);
}
