package online_toeic_test_springboot.data;

import java.util.List;
import java.util.Optional;

import online_toeic_test_springboot.domain.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ToeicTestRetriveMapper {

  @Select("SELECT * FROM TEST")
  List<Test> queryAllTests();

  @Select("SELECT * FROM TEST WHERE id = #{id}")
  Optional<Test> queryTestById(int id);

  @Select("SELECT * FROM PART WHERE test_id = #{testId} AND part_num = #{partNum}")
  Optional<Part> queryPartByTestIdAndPartNum(int testId, int partNum);

  @Select("SELECT * FROM QUESTION WHERE part_id = #{partId} ORDER BY `index`")
  List<Question> queryQuestionsByPartId(int partId);

  @Select("SELECT * FROM QUESTION_GROUP WHERE part_id = #{partId} ORDER BY `index`")
  List<QuestionGroup> queryGroupsByPartId(int partId);

  @Select("SELECT * FROM QUESTION WHERE group_id = #{groupId} ORDER BY `index`")
  List<Question> queryQuestionsByGroupId(int groupId);

  @Select("SELECT * FROM ANSWER WHERE question_id = #{questionId}")
  List<Answer> queryAnswersByQuestionId(int questionId);
}
