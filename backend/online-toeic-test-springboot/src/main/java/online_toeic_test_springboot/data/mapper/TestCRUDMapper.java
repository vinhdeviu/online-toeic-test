package online_toeic_test_springboot.data.mapper;

import online_toeic_test_springboot.domain.model.Test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TestCRUDMapper {

  @Select("SELECT * FROM TEST")
  List<Test> queryAllTests();

  @Select("SELECT * FROM TEST WHERE id = #{id}")
  Optional<Test> queryTestById(int id);
}
