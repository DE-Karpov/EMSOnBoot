package ru.itis.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.demo.models.Product;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Product, Long> {
    List<Product> findAll();

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from cart_product where cart_id = ?1 and product_id = ?2")
    void deleteProductFromCart(Long cart_id, Long product_id);
}
