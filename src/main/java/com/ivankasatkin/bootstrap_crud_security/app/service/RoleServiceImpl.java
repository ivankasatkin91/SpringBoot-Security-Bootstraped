package com.ivankasatkin.bootstrap_crud_security.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ivankasatkin.bootstrap_crud_security.app.dao.RoleDao;
import com.ivankasatkin.bootstrap_crud_security.app.model.Role;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> listRoles() {
        return roleDao.listRoles();
    }
}
