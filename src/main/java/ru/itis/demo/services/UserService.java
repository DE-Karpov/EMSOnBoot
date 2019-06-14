package ru.itis.demo.services;

import ru.itis.demo.models.User;

import java.util.Optional;

public interface UserService {

    void saveUser(User user);

    Optional<User> findByLogin(String login);

}
