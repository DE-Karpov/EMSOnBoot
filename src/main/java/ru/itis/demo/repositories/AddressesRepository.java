package ru.itis.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.demo.models.Address;

public interface AddressesRepository extends JpaRepository<Address, Long> {

}
