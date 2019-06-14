package ru.itis.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.demo.models.User;
import ru.itis.demo.repositories.UsersRepository;

import java.util.Optional;

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
}
