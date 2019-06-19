package ru.itis.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.demo.models.Address;

@Repository
public interface AddressesRepository extends JpaRepository<Address, Long> {

}
