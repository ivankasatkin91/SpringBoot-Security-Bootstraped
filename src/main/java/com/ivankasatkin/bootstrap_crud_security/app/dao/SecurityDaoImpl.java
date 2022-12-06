package com.ivankasatkin.bootstrap_crud_security.app.dao;

import com.ivankasatkin.bootstrap_crud_security.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class SecurityDaoImpl implements SecurityDao{

    @Autowired
    private EntityManager entityManager;

    @Override
    public User getUserByUsername(String username) {
        return entityManager.createQuery("select u from User u left join fetch u.roles where u.username = :login", User.class)
                .setParameter("login", username)
                .getSingleResult();
    }
}
