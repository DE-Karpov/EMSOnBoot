package ru.itis.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.demo.models.State;
import ru.itis.demo.repositories.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public void changeState(Long id, String state) {
        if (state.equals(State.ACTIVE.toString()))
            state = State.BANNED.toString();
        else
            state = State.ACTIVE.toString();

        adminRepository.changeState(id, state);
    }

    @Override
    public String getState(Long id) {
        return adminRepository.getState(id);
    }
}
