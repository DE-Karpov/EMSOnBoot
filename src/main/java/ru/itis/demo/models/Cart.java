package ru.itis.demo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "cart")
@ToString(exclude = {"user", "cartProducts"})
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(mappedBy = "cart")
    private User user;
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(
            name = "cart_product",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;
    @OneToMany(mappedBy = "cart")
    private List<CartProduct> cartProducts;

    public Cart() {
    }


    public Cart(long cart_id, User user, List<Product> listOfProducts) {
        products = new ArrayList<>();
    }

    public void add(Product product) {
        if (products == null) {
            products = new ArrayList<>();
            products.add(product);
        } else {
            products.add(product);
        }
    }

    public void remove(Product product) {
        products.remove(product);
    }

}
