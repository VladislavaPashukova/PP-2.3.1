package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class UserDAOImpl implements UserDAO{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery(
                "SELECT user FROM User user", (User.class)
        ).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.createQuery(
                "DELETE FROM User user WHERE user.id=:id"
        ).setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void editUser(Long id, User editUser) {
        User eUser = getUserById(id);
        eUser.setName(editUser.getName());
        eUser.setSurname(editUser.getSurname());
        eUser.setEmail(editUser.getEmail());
        entityManager.merge(eUser);
    }
}
