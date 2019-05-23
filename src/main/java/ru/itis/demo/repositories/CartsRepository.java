package ru.itis.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.demo.models.Cart;

public interface CartsRepository extends JpaRepository<Cart, Long> {

    @Query(nativeQuery = true, value = "delete from cart_product where cart_id = ? and product_id = ?")
    void deleteCartProduct(Long cart_id, Long product_id);

}
