package web.dao;

import org.springframework.stereotype.Repository;
import web.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getUsers() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public User getSingleUserById(Long id) {
        TypedQuery<User> typedQuery = em.createQuery("select u from User u where u.id = :id", User.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getResultList().stream().findFirst().orElse(null);
    }

    @Override
    public void update(User user) {
        em.merge(user);
    }

    @Override
    public void delete(Long id) {
        em.remove(getSingleUserById(id));
    }
}
