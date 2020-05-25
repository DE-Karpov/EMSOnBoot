package ru.itis.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.demo.models.Order;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Order, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM public.ems_order o WHERE o.customer_id = ?")
    List<Order> findAllByUserId(Long id);

    @Query(nativeQuery = true, value = "SELECT amount FROM ems_order o WHERE o.customer_id = ?1 AND o.product_id = ?2")
    Long getAmountByUserIdAndProductId(Long userId, Long productId);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE ems_order o SET amount = ?3 WHERE o.customer_id = ?1 AND o.product_id = ?2")
    void updateAmount(Long userId, Long productId, Long amount);
}
