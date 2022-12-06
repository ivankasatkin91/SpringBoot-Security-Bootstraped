package com.ivankasatkin.bootstrap_crud_security.app;

import com.ivankasatkin.bootstrap_crud_security.app.model.User;
import com.ivankasatkin.bootstrap_crud_security.app.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)

public class UserTests {

    @Autowired
    private UserRepository repo;

//    @PersistenceContext
//    private EntityManager em;

    @Test
    public void getUserAndRoles() {
        User user = repo.findById(1).get();
        System.out.println(user);
    }

}
