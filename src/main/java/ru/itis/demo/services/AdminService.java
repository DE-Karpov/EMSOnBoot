package ru.itis.demo.services;

public interface AdminService {

    void changeState(Long id, String state);

    String getState(Long id);

}
