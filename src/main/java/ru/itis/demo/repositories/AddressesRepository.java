package ru.itis.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.demo.models.Address;

import java.util.Optional;


public interface AddressesRepository extends JpaRepository<Address, Long> {

}
