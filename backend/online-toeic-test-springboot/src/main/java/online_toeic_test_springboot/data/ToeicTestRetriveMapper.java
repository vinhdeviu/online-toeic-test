package online_toeic_test_springboot.data;

import java.util.List;
import java.util.Optional;

import online_toeic_test_springboot.domain.Part;
import online_toeic_test_springboot.domain.Question;
import online_toeic_test_springboot.domain.QuestionGroup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ToeicTestRetriveMapper {

  @Select("SELECT * FROM PART WHERE id = #{id}")
  Optional<Part> queryPartById(int id);

  @Select("SELECT * FROM QUESTION WHERE part_id = #{partId}")
  List<Question> queryQuestionsByPartId(int partId);

  @Select("SELECT * FROM QUESTION WHERE part_id = #{partId} AND difficulty = #{difficulty} ORDER BY RAND() LIMIT 0,#{numRandom}")
  List<Question> queryRandomQuestionsByPartIdAndDifficulty(int partId, int difficulty, int numRandom);

  @Select("SELECT * FROM QUESTION_GROUP WHERE part_id = #{partId} AND difficulty = #{difficulty} ORDER BY RAND() LIMIT 0,#{numRandom}")
  List<QuestionGroup> queryRandomGroupsByPartIdAndDifficulty(int partId, int difficulty, int numRandom);

  @Select("SELECT * FROM QUESTION WHERE group_id = #{groupId} ORDER BY RAND() LIMIT 0,#{numRandom}")
  List<Question> queryRandomQuestionsByGroupId(int groupId, int numRandom);
}
