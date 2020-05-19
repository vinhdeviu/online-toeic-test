package online_toeic_test_springboot.service;

import online_toeic_test_springboot.domain.model.User;

import java.util.List;

public interface UserService {
    User login(User user);

    void register(User user);

    List<User> getAllExaminees();

    void updateUser(User user);
}
