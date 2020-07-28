package ru.alexander.springmvc.DAO;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.alexander.springmvc.model.Role;
import ru.alexander.springmvc.model.User;

import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
    Set<Role> roleSet = new HashSet<>();
    Role role = new Role(1l, "ROLE_USER");


    public UserDaoImpl() {
//        User user = new User("admin", "admin", roleSet);
//        list.add(user);
    }

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public User findById(Long id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public void deleteUser(Long id) {
        User user = findById(id);
        sessionFactory.getCurrentSession().delete(user);
    }

//    public User getUserByName(String name) {
//        Query query = sessionFactory.getCurrentSession().createQuery("from User WHERE name = :paramName");
//        query.setParameter("paramName", name);
//        List<User> userList = query.list();
//
//
////        User user = findById(userList.get(0).getId());
//        return userList.get(0);
//    }

    //    public User getUserByName(String name){
//        User user = (User) sessionFactory.getCurrentSession().createQuery("from User where name = '" + name + "'").uniqueResult();
//        return user;
//    }
    public User getUserByName(String name) {
        List<User> list = listUsers();

        for (User user : list) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;

//        if (!list.contains(name))
//            return null;
//        return list.get(0);
    }
}

