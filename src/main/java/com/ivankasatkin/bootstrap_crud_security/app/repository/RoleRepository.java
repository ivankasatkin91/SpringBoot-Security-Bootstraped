package com.ivankasatkin.bootstrap_crud_security.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ivankasatkin.bootstrap_crud_security.app.model.Role;

        // Repository is used for JUnit tests

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
