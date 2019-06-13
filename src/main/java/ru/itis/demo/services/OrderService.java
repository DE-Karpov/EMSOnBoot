package ru.itis.demo.services;

import ru.itis.demo.models.*;

import java.util.List;

public interface OrderService {
    List<Product> findOrders(Long userId);
    void addOrder(Order order);
}
