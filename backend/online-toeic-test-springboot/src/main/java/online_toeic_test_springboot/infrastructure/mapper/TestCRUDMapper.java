package online_toeic_test_springboot.infrastructure.mapper;

import online_toeic_test_springboot.domain.model.Test;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TestCRUDMapper {

  @Select("SELECT * FROM TEST")
  List<Test> queryAllTests();

  @Select("SELECT * FROM TEST WHERE test_name = #{testName}")
  List<Test> queryTestsByName(String testName);

  @Select("SELECT * FROM TEST WHERE id = #{id}")
  Optional<Test> queryTestById(int id);

  @Select("SELECT * FROM TEST WHERE id = (SELECT MIN(id) FROM TEST)")
  Optional<Test> queryTheFirstTest();

  @Insert("INSERT INTO Test (test_name,audio_link) VALUES (#{testName},#{audioLink})")
  @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
  void insertTest(Test test);

  @Update("UPDATE Test SET test_name=#{testName},audio_link=#{audioLink} WHERE id=#{id}")
  void updateTest(Test test);

  @Delete("DELETE FROM Test WHERE id=#{id}")
  boolean deleteTestById(int id);
}
