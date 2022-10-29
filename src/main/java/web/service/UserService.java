package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> allUsers();
    void saveUser(User user);
    void delUser(Long id);
    User getUserById(Long id);
    void editUser(Long id, User editUser);
}
