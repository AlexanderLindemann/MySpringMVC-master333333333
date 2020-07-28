package ru.alexander.springmvc.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alexander.springmvc.DAO.RoleDao;
import ru.alexander.springmvc.model.Role;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    @Transactional
    @Override
    public Role findByName(String name) {
        Role role = new Role(1l,"ROLE_USER");
        return role;
    }

    @Transactional
    @Override
    public List<Role> listRole() {
        return roleDao.listRole();
    }
}
