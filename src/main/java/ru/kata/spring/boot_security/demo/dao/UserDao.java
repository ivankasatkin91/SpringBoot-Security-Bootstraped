package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    User getUserById(int id);

    void updateUser(int id, User user);

    void deleteUser(int id);

    List<User> listUsers();

}
