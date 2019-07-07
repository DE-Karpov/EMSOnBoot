package ru.itis.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.itis.demo.models.Cart;
import ru.itis.demo.models.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartsRepository extends JpaRepository<Cart, Long> {

    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO cart(owner_id) values (?)")
    void save(Long ownerId);

    Optional<Cart> findCartById(Long id);

}
