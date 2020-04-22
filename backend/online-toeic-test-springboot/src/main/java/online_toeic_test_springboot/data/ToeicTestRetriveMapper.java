package online_toeic_test_springboot.data;

import java.util.List;
import java.util.Optional;

import online_toeic_test_springboot.domain.Part;
import online_toeic_test_springboot.domain.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ToeicTestRetriveMapper {

  @Select("SELECT * FROM PART WHERE id = #{id}")
  Optional<Part> queryPartById(int id);


  @Select("SELECT * FROM QUESTION WHERE part_id = #{partId} ORDER BY RAND() LIMIT 0,4")
  List<Question> queryQuestionsByPartId(int partId);
}
