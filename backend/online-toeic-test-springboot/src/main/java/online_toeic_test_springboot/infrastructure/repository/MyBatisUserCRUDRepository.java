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
  public List<User> getAllUsers() {
    return userCRUDMapper.queryAllUsers();
  }

  @Override
  public List<User> getUsersByRole(int role) {
    return userCRUDMapper.queryUsersByRole(role);
  }

  @Override
  public User getUserById(int id) {
    Optional<User> optionalUser = userCRUDMapper.queryUserById(id);
    if(!optionalUser.isPresent()) {
      throw new EntityNotFoundException("user not found");
    }
    return optionalUser.get();
  }

  @Override
  public User login(String email, String password, int role) {
    Optional<User> optionalUser = userCRUDMapper.queryUserByEmailAndPasswordAndRole(email, password, role);
    if(!optionalUser.isPresent()) {
      throw new EntityNotFoundException("wrong email or password");
    }
    return optionalUser.get();
  }

  @Override
  public void updateUser(User user) {
    Optional<User> optionalUser = userCRUDMapper.queryUserById(user.getId());
    if(!optionalUser.isPresent()) {
      throw new EntityNotFoundException("user not found");
    }
    userCRUDMapper.updateUser(user);
  }

  @Override
  public void createUser(User user) {
    Optional<User> optionalUser = userCRUDMapper.queryUserByEmail(user.getEmail());
    if(optionalUser.isPresent()) {
      throw new EntityNotFoundException("email is already registered");
    }
    userCRUDMapper.insertUser(user);
  }

  @Override
  public void deleteUser(int id) {
    if(!userCRUDMapper.deleteUserById(id)) {
      throw new EntityNotFoundException("user not found");
    }
  }
}
