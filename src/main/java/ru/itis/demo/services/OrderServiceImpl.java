package ru.itis.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.demo.models.*;
import ru.itis.demo.repositories.*;

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
    public Order findOrders(Long userId) {
        List<Order> orders = ordersRepository.findAllByUserId(userId);
        System.out.println(orders);
        Order allOrder;
        try {
            allOrder = orders.get(0);
        }
        catch (Exception e){
            allOrder = null;
            System.out.println(")");
        }
        for (Order order : orders) {
            Product newProduct = productsRepository.findAllById(order.getProductId());
            newProduct.setAmount(order.getAmount());
            allOrder.getProductList().add(newProduct);
        }
        return allOrder;
    }

    @Override
    public void addOrder(Order order) {
        ordersRepository.save(order);
    }

    @Override
    public Long getAmount(Long customerId, Long productId) {
        return ordersRepository.getAmountByUserIdAndProductId(customerId, productId);
    }
}
