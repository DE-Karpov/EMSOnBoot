package ru.itis.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.itis.demo.models.Cart;

import java.util.Optional;

@Repository
public interface CartsRepository extends JpaRepository<Cart, Long> {

    @Query(nativeQuery = true, value = "delete from cart_product where cart_id = ? and product_id = ?")
    void deleteCartProduct(Long cart_id, Long product_id);

    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO cart(owner_id) values (?)")
    void save(Long ownerId);

}
