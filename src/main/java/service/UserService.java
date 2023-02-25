package service;

import jakarta.persistence.EntityManager;
import model.User;

public class UserService {

    private final EntityManager em;

    public UserService(EntityManager em) {
        this.em = em;
    }

    public void save(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    public User findById(Long id) {
        return em.find(User.class, id);
    }

    public void deleteById(Long id) {
        em.getTransaction().begin();
        em.remove(em.getReference(User.class,id));
        em.getTransaction().commit();
    }


}
