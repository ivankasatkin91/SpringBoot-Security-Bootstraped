package com.ivankasatkin.bootstrap_crud_security.app.dao;

import com.ivankasatkin.bootstrap_crud_security.app.model.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    User getUserById(int id);

    User getUserByUsername(String username);

    void updateUser(int id, User user);

    void deleteUser(int id);

    List<User> listUsers();

}
