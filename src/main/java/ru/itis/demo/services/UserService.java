package ru.itis.demo.services;

import ru.itis.demo.models.Address;
import ru.itis.demo.models.Product;
import ru.itis.demo.models.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService {

    void saveUser(User user);

    Optional<User> findByLogin(String login);

    String parseOfAddress(Set<Address> addressSet);

    List<User> findAll();

}
