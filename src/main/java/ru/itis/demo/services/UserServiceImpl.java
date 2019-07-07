package ru.itis.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.demo.models.Address;
import ru.itis.demo.models.Product;
import ru.itis.demo.models.User;
import ru.itis.demo.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {

    private final UsersRepository usersRepository;

    @Autowired
    public UserServiceImpl(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @Override
    public void saveUser(User user) {
            usersRepository.save(user);
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return usersRepository.findByLogin(login);
    }

    @Override
    public String parseOfAddress(Set<Address> addressSet) {
        String address = "";
        for (Address addresses : addressSet){
            address = "City of " + addresses.getCityName() + " " + addresses.getStreetName() + ", street building №" + addresses.getBuildingNumber();
        }
        return address;
    }

    @Override
    public List<User> findAll() {
        return usersRepository.findAll();
    }

}
