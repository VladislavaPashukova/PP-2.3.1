package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    List<User> allUsers();
    void saveUser(User user);
    void delUser(Long id);
    User getUserById(Long id);
    void editUser(Long id, User editUser);
}
