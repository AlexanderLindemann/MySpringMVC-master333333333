package ru.alexander.springmvc.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.alexander.springmvc.model.Role;
import ru.alexander.springmvc.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager em;

    public UserDaoImpl() {
    }

    @Override
    public void add(User user) {
        em.persist(user);
    }

    public void update(User user) {
        em.merge(user);
    }

    @Override
    public List<User> listUsers() {
//        Query query = em.createQuery("from User");
//        return query.getResultList();

        List<User> list = em.createQuery("from User").getResultList();

        return list;
    }


    @Override
    public User findById(Long id) {
        return em.find(User.class, new Long(id));
    }

    @Override
    public void deleteUser(Long id) {
        User user = findById(id);
        em.remove(user);
    }

    public User getUserByName(String name) {
        List<User> list = listUsers();

        for (User user : list) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }
}

