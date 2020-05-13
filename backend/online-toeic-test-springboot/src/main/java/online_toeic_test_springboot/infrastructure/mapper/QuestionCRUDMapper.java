package online_toeic_test_springboot.infrastructure.mapper;

import online_toeic_test_springboot.domain.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface QuestionCRUDMapper {

  @Select("SELECT * FROM QUESTION WHERE id = #{id}")
  Optional<Question> queryQuestionById(int id);

  @Select("SELECT * FROM QUESTION WHERE part_id = #{partId} ORDER BY `index`")
  List<Question> queryQuestionsByPartId(int partId);

  @Select("SELECT * FROM QUESTION WHERE group_id = #{groupId} ORDER BY `index`")
  List<Question> queryQuestionsByGroupId(int groupId);

  @Select("SELECT COUNT(id) FROM QUESTION WHERE part_id = #{partId}")
  int queryCountQuestionsByPartId(int partId);

  @Insert("INSERT INTO Question (`index`,part_id,group_id,image_link,question_tittle,correct_answer,correct_answer_id) VALUES (#{index},#{partId},#{groupId},#{imageLink},#{questionTittle},#{correctAnswer},#{correctAnswerId})")
  @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
  void insertQuestion(Question question);
}
