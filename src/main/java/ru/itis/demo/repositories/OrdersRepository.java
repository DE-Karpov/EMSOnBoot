package ru.itis.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.demo.models.Order;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Order, Long> {

    @Query(nativeQuery = true,value = "SELECT * FROM public.order o WHERE o.customer_id = ?")
    List<Order> findAllByUserId(Long id);
}
