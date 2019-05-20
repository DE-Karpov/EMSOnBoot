package ru.itis.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.demo.models.User;
import ru.itis.demo.repositories.UsersRepository;
import ru.itis.demo.forms.LoginForm;

import java.util.Optional;

@Service
public class SignInServiceImpl implements SignInService {

    private UsersRepository usersRepository;

    @Autowired
    public SignInServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
//
//    @Override
//    public Optional<User> login(LoginForm loginForm) {
//        if (usersRepository != null) {
//            return usersRepository.findOneByLoginAndHashPassword(loginForm.getLogin(), loginForm.getPassword());
//        } else {
//            Optional<User> customer = usersRepository.findByLogin(loginForm.getLogin());
//            if (customer.isPresent() && loginForm.getPassword().equals(customer.get().getHashPassword())) { //encoder.matches(password, user.getHashPassword()
//                return customer;
//            }
//            return Optional.empty();
//        }
   // }

}
