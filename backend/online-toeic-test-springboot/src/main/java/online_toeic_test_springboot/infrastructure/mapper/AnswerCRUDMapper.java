package online_toeic_test_springboot.infrastructure.mapper;

import online_toeic_test_springboot.domain.model.Answer;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AnswerCRUDMapper {

  @Select("SELECT * FROM ANSWER WHERE question_id = #{questionId}")
  List<Answer> queryAnswersByQuestionId(int questionId);

  @Select("SELECT * FROM ANSWER ORDER BY question_id")
  List<Answer> queryAllAnswers();

  @Insert("INSERT INTO Answer (question_id,content) VALUES (#{questionId},#{content})")
  @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
  void insertAnswer(Answer answer);

  @Update("UPDATE Answer SET question_id=#{questionId},content=#{content} WHERE id=#{id}")
  void updateAnswer(Answer answer);

  @Delete("DELETE FROM Answer WHERE question_id=#{questionId}")
  boolean deleteAnswersByQuestionId(int questionId);
}
