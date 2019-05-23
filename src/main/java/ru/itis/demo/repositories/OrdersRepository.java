package ru.itis.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.demo.models.Order;

public interface OrdersRepository extends JpaRepository<Order, Long> {
}
