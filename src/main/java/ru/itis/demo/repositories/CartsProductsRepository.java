package ru.itis.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.demo.models.CartProduct;

public interface CartsProductsRepository extends JpaRepository<CartProduct, Long> {

    @Transactional
    void deleteCartProductByCart_IdAndProduct_Id(Long cart_id, Long product_id);
}
