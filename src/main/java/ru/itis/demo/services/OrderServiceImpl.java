package ru.itis.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.demo.models.*;
import ru.itis.demo.repositories.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final ProductsRepository productsRepository;
    private final OrdersRepository ordersRepository;

    @Autowired
    public OrderServiceImpl(ProductsRepository productsRepository, OrdersRepository ordersRepository) {
        this.productsRepository = productsRepository;
        this.ordersRepository = ordersRepository;
    }

    @Override
    public List<Product> findOrders(Long userId) {
        List<Order> orders = ordersRepository.findAllByUserId(userId);
        System.out.println(orders);
        List<Product> products = new ArrayList<>();
        for (Order order : orders) {
            products.add(productsRepository.getOne(order.getProductId()));
        }
        return products;
    }

    @Override
    public void addOrder(Order order) {
            ordersRepository.save(order);
    }

    @Override
    public Long getAmount(Long customerId, Long productId) {
       return ordersRepository.getAmountByUserIdAndProductId(customerId,productId);
    }
}
