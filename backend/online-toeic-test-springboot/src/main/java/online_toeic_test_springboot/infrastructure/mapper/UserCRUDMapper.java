package online_toeic_test_springboot.infrastructure.mapper;

import online_toeic_test_springboot.domain.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserCRUDMapper {

  @Select("SELECT * FROM User ORDER BY role")
  List<User> queryAllUsers();

  @Select("SELECT * FROM User where role = #{role}")
  List<User> queryUsersByRole(int role);

  @Select("SELECT * FROM User WHERE id = #{id}")
  Optional<User> queryUserById(int id);

  @Select("SELECT * FROM User WHERE email = #{email}")
  Optional<User> queryUserByEmail(String email);

  @Select("SELECT * FROM User WHERE email = #{email} AND password = #{password} AND role = #{role}")
  Optional<User> queryUserByEmailAndPasswordAndRole(String email, String password, int role);

  @Insert("INSERT INTO User (email,password,name,role) VALUES (#{email},#{password},#{name},#{role})")
  @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
  void insertUser(User user);

  @Update("UPDATE User SET email=#{email},password=#{password},name=#{name},role=#{role} WHERE id=#{id}")
  void updateUser(User user);

  @Delete("DELETE FROM User WHERE id=#{id}")
  boolean deleteUserById(int id);
}
