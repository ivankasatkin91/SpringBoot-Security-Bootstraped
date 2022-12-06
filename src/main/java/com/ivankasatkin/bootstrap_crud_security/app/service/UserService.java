package com.ivankasatkin.bootstrap_crud_security.app.service;

import com.ivankasatkin.bootstrap_crud_security.app.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    List<User> listUsers();

    User getUserById(int id);

    void updateUser(int id, User user);

    void deleteUser(int id);
}
