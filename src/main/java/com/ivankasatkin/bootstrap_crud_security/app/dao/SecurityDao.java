package com.ivankasatkin.bootstrap_crud_security.app.dao;

import com.ivankasatkin.bootstrap_crud_security.app.model.User;

public interface SecurityDao {

    User getUserByUsername(String username);
}
