package ru.itis.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
@ToString(exclude = "users")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country_code")
    private Integer countryCode;
    @Column(name = "city_name")
    private String cityName;
    @Column(name = "street_name")
    private String streetName;
    @Column(name = "building_number")
    private Integer buildingNumber;

    @ManyToMany(mappedBy = "addresses")
    @Column(name = "user_id")
    @JsonIgnore
    private List<User> users;
}
