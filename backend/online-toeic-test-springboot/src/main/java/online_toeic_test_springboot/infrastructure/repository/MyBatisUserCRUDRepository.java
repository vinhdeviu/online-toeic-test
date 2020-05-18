package online_toeic_test_springboot.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import online_toeic_test_springboot.domain.model.*;
import online_toeic_test_springboot.domain.repository.UserCRUDRepository;
import online_toeic_test_springboot.exception.EntityNotFoundException;
import online_toeic_test_springboot.infrastructure.mapper.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
@RequiredArgsConstructor
public class MyBatisUserCRUDRepository implements UserCRUDRepository {

  private final UserCRUDMapper userCRUDMapper;

  @Override
  public List<User> getUsersByRole(int role) {
    return userCRUDMapper.queryUsersByRole(role);
  }

  @Override
  public User getUserById(int id) {
    Optional<User> user = userCRUDMapper.queryUserById(id);
    if(!user.isPresent()) {
      throw new EntityNotFoundException("user not found");
    }
    return user.get();
  }

  @Override
  public User getUserByEmailAndPassword(String email, String password) {
    Optional<User> user = userCRUDMapper.queryUserByEmailAndPassword(email, password);
    if(!user.isPresent()) {
      throw new EntityNotFoundException("wrong email or password");
    }
    return user.get();
  }

  @Override
  public void updateUser(User user) {
    userCRUDMapper.updateUser(user);
  }

  @Override
  public void createUser(User user) {
    userCRUDMapper.insertUser(user);
  }

  @Override
  public void deleteUser(int id) {
    userCRUDMapper.deleteUserById(id);
  }
}
