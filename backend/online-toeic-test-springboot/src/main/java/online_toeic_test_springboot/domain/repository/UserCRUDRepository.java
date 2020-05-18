package online_toeic_test_springboot.domain.repository;

import online_toeic_test_springboot.domain.model.User;

import java.util.List;

public interface UserCRUDRepository {
    List<User> getUsersByRole(int role);

    User getUserById(int id);

    User getUserByEmailAndPassword(String email, String password);

    void updateUser(User user);

    void createUser(User user);

    void deleteUser(int id);
}
