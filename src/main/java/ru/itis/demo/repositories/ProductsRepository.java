package ru.itis.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.demo.models.Product;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Long> {
    List<Product> findAll();

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from cart_product WHERE cart_id = ?1 and product_id = ?2")
    void deleteProductFromCart(Long cart_id, Long product_id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from cart_product where cart_id = ?1")
    void deleteProductsFromCart(Long cart_id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE cart_product SET amount = ?1 WHERE cart_id = ?2 and product_id = ?3")
    void updateAmount(Long amount, Long cart_id, Long product_id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE from cart_product WHERE cart_product.amount IS NULL")
    void deleteDublicates();

    @Query(nativeQuery = true, value = "SELECT id FROM product WHERE name = ?1")
    Long findProductIdByName(String name);

    @Query(nativeQuery = true, value = "SELECT amount FROM cart_product WHERE cart_id = ?1 AND product_id = ?2")
    Long getAmount(Long cart_id, Long product_id);

    Product findAllById(Long productId);
}
