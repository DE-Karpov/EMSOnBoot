package ru.itis.demo.services;

import ru.itis.demo.models.*;

public interface OrderService {
    Order findOrders(Long userId);

    void addOrder(Order order);

    Long getAmount(Long customerId, Long productId);
}
