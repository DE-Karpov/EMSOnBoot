package ru.itis.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder()
@Entity
@Table(name = "product")
@ToString(exclude = "listOfCarts")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "products")
    @Column(name = "cart_id")
    @JsonIgnore
    List<Cart> listOfCarts;
}
