package ru.itis.demo.services;

import ru.itis.demo.models.Address;
import ru.itis.demo.models.Cart;
import ru.itis.demo.models.User;

public interface OrderService {

    Cart getUserCard(SignInService signInService, String login);

    void addOrders(String ids, Address address, User user);

    Boolean contains(Long id, Cart cart);

}
