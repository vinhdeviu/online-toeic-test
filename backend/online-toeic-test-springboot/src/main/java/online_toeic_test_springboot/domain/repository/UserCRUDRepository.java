package online_toeic_test_springboot.domain.repository;

import online_toeic_test_springboot.domain.model.User;

import java.util.List;

public interface UserCRUDRepository {

    List<User> getAllUsers();

    List<User> getUsersByRole(int role);

    User getUserById(int id);

    User login(String email, String password, int role);

    void updateUser(User user);

    void createUser(User user);

    void deleteUser(int id);
}
