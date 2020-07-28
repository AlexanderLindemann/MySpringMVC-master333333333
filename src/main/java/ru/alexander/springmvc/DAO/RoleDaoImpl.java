package ru.alexander.springmvc.DAO;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.alexander.springmvc.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    EntityManager em;

    @Transactional
    @Override
    public Role findByName(String name) {
        Query query = em.createQuery("FROM Role u where u.role = :name");
        query.setParameter("name", name);
        List<Role> list = query.getResultList();
        return list.get(0);
    }

    @Transactional
    @Override
    public List<Role> listRole() {
        List<Role> list = em.createQuery("from Role").getResultList();

        return list;
    }
}
