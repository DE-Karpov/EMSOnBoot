package ru.itis.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.demo.models.*;
import ru.itis.demo.repositories.AddressesRepository;
import ru.itis.demo.repositories.CartsProductsRepository;
import ru.itis.demo.repositories.CartsRepository;
import ru.itis.demo.repositories.OrdersRepository;

@Service
public class OrderServiceImpl implements OrderService {

    private AddressesRepository addressesRepository;
    private CartsProductsRepository cartsProductsRepository;
    private CartsRepository cartsRepository;
    private OrdersRepository ordersRepository;

    @Autowired
    public OrderServiceImpl(CartsProductsRepository cartsProductsRepository, OrdersRepository ordersRepository, AddressesRepository addressesRepository, CartsRepository cartsRepository) {
        this.addressesRepository = addressesRepository;
        this.cartsRepository = cartsRepository;
        this.ordersRepository = ordersRepository;
        this.cartsProductsRepository = cartsProductsRepository;
    }

    @Override
    public Cart getUserCard(SignInService signInService, String login) {
        return null;
    }

    @Override
    public void addOrders(String ids, Address address, User user) {
        for (long i = 0L; i < ids.length(); i++) {
            Long id = (long) Character.digit(ids.charAt(Math.toIntExact(i)), 10);
            if (contains(id, user.getCart())) {
                Order order = Order.builder()
                        .id(i + 1)
                        .user(user)
                        .productId(id)
                        .address(address)
                        .status("In order")
                        .build();
                addressesRepository.save(address);
                ordersRepository.save(order);
            } else {
                System.err.println("Thing №" + id + 1 + " is not exists.");
            }
        }
    }

    @Override
    public Boolean contains(Long id, Cart cart) {
        for (Product product : cart.getProducts()) {
            if (product.getId().equals(id)) {
                cart.remove(product);
                cartsProductsRepository.deleteCartProductByCart_IdAndProduct_Id(cart.getId(), id);
                return true;
            }
        }
        return false;
    }

}
