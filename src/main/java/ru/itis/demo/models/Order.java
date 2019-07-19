package ru.itis.demo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ems_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private Long productId;
//    @ManyToOne
//    @JoinColumn(name = "address_id")
//    private Address address;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User user;
    private String status;
    private Long amount;


    @Transient
    private List<Product> productList = new ArrayList<>();

}
