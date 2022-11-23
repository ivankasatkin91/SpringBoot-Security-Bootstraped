package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.User;

public interface SecurityDao {

    User getUserByUsername(String username);
}
