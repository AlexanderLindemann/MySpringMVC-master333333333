package ru.alexander.springmvc.service;

import ru.alexander.springmvc.model.Role;

import java.util.List;

public interface RoleService {
    Role findByName(String name);
    public List<Role> listRole();
}
