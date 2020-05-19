package online_toeic_test_springboot.service;

import lombok.RequiredArgsConstructor;
import online_toeic_test_springboot.domain.model.User;
import online_toeic_test_springboot.domain.repository.UserCRUDRepository;
import online_toeic_test_springboot.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final int EXAMINEE_ROLE_INT_VALUE = 1;

    @Autowired
    private final UserCRUDRepository userCRUDRepository;

    @Override
    public User login(User user) {
        return userCRUDRepository.login(user.getEmail(), user.getPassword());
    }

    @Override
    public void register(User user) {
        userCRUDRepository.createUser(user);
    }

    @Override
    public List<User> getAllExaminees() {
        return userCRUDRepository.getUsersByRole(EXAMINEE_ROLE_INT_VALUE);
    }

    @Override
    public void updateUser(User user) {
        userCRUDRepository.updateUser(user);
    }
}
