package ru.alexander.springmvc.DAO;

import ru.alexander.springmvc.model.Role;

import java.util.List;

public interface RoleDao {
    Role findByName(String name);
    public List<Role> listRole();
}
