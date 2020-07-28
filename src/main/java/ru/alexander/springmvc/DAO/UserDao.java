package ru.alexander.springmvc.DAO;

import ru.alexander.springmvc.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> listUsers();
    User findById (Long id);
    void deleteUser(Long id);
    void update(User user);
    public User getUserByName(String name);
}
