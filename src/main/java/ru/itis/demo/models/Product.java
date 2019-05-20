package ru.itis.demo.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder()
@Entity
@Table(name = "product")
@ToString(exclude = "cartProducts")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private List<CartProduct> cartProducts;
}
