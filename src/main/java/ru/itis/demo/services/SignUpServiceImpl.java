package ru.itis.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.demo.forms.UserForm;
import ru.itis.demo.models.Cart;
import ru.itis.demo.models.Role;
import ru.itis.demo.models.State;
import ru.itis.demo.models.User;
import ru.itis.demo.repositories.CartsRepository;
import ru.itis.demo.repositories.UsersRepository;

@Service
public class SignUpServiceImpl implements SignUpService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final CartsRepository cartsRepository;

    @Autowired
    public SignUpServiceImpl(UsersRepository usersRepository, PasswordEncoder passwordEncoder, CartsRepository cartsRepository) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.cartsRepository = cartsRepository;

    }

    @Override
    public void signUp(UserForm userForm) {
        String hashPassword = passwordEncoder.encode(userForm.getPassword());

        User user = User.builder()
                .login(userForm.getLogin())
                .hashPassword(hashPassword)
                .name(userForm.getName())
                .age(userForm.getAge())
                .gender(userForm.getGender())
                .role(Role.USER)
                .state(State.ACTIVE)
                .build();

        usersRepository.save(user);

        if (usersRepository.findByLogin(user.getLogin()).isPresent()) {
            cartsRepository.save(usersRepository.findByLogin(user.getLogin()).get().getId());
        }
        else {
            throw new IllegalArgumentException();
        }
    }
}
