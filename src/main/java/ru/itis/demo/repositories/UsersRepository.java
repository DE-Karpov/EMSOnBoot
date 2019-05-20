package ru.itis.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.demo.models.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login);
}
