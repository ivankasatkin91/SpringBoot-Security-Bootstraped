package com.ivankasatkin.bootstrap_crud_security.app.dao;

import com.ivankasatkin.bootstrap_crud_security.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private BCryptPasswordEncoder bCrypt;

    @Override
    public void addUser(User user) {
        user.setPassword(bCrypt.encode(user.getPassword()));
        entityManager.persist(user);
    }

    @Override
    public User getUserById(int id) {
        return entityManager.createQuery("select u from User u where u.id = " + id, User.class)
                .getSingleResult();
    }

    @Override
    public User getUserByUsername(String username) {
        return entityManager.createQuery("select u from User u where u.username = :login", User.class)
                .setParameter("login", username)
                .getSingleResult();
    }

    @Override
    public void updateUser(int id, User user) {
        User editedUser = getUserById(id);
        editedUser.setName(user.getName());
        editedUser.setSurname(user.getSurname());
        editedUser.setUsername(user.getUsername());
        editedUser.setPassword(bCrypt.encode(user.getPassword()));
        editedUser.setRoles(user.getRoles());
        entityManager.merge(editedUser);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.createQuery("delete from User where id = " + id)
                .executeUpdate();
    }

    @Override
    public List<User> listUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }
}
