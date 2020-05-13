package online_toeic_test_springboot.data.mapper;

import online_toeic_test_springboot.domain.model.Answer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AnswerCRUDMapper {

  @Select("SELECT * FROM ANSWER WHERE question_id = #{questionId}")
  List<Answer> queryAnswersByQuestionId(int questionId);
}
