package ru.itis.demo.models;

import lombok.*;
import ru.itis.demo.forms.CartForm;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cart")
@ToString(exclude = "user")
public class Cart {

    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "cart")
    private User user;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(
            name = "cart_product",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products;

    public void add(Product product) {
        if (products == null) {
            products = new HashSet<>();
            products.add(product);
        } else {
            products.add(product);
        }
    }

    public CartForm buildForm(Cart cart){
        return CartForm.builder()
                .ownerId(cart.getUser().getId())
                .build();
    }

    public void remove(Product product) {
        products.remove(product);
    }

}
