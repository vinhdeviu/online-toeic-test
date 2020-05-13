package online_toeic_test_springboot.infrastructure.mapper;

import online_toeic_test_springboot.domain.model.Answer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AnswerCRUDMapper {

  @Select("SELECT * FROM ANSWER WHERE question_id = #{questionId}")
  List<Answer> queryAnswersByQuestionId(int questionId);

  @Insert("INSERT INTO Answer (question_id,content) VALUES (#{questionId},#{content})")
  @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
  void insertAnswer(Answer answer);
}
