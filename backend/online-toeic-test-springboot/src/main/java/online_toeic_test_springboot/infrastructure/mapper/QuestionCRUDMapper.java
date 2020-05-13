package online_toeic_test_springboot.infrastructure.mapper;

import online_toeic_test_springboot.domain.model.Question;
import org.apache.ibatis.annotations.*;

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

  @Update("UPDATE Part SET part_id=#{partId},group_id=#{groupId},`index`=#{index},image_link=#{imageLink},question_tittle=#{questionTittle},correct_answer=#{correctAnswer},correct_answer_id=#{correctAnswerId} WHERE id=#{id}")
  void updateQuestion(Question question);

  @Delete("DELETE FROM Question WHERE id=#{id}")
  void deleteQuestionById(int id);
}
