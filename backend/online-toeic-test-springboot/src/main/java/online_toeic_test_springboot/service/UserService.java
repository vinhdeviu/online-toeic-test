package online_toeic_test_springboot.service;

import online_toeic_test_springboot.domain.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User adminLogin(User user);

    User examineeLogin(User user);

    void register(User user);

    List<User> getAllExaminees();

    void updateUser(User user);

    User getUserById(int userId);
}
