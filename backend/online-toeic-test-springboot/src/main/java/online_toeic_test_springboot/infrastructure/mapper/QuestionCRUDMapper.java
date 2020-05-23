package online_toeic_test_springboot.infrastructure.mapper;

import online_toeic_test_springboot.domain.model.Question;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface QuestionCRUDMapper {

  @Select("SELECT * FROM QUESTION WHERE id = #{id}")
  Optional<Question> queryQuestionById(int id);

  @Select("SELECT * FROM QUESTION ORDER BY part_id, `index`")
  List<Question> queryAllQuestions();

  @Select("SELECT * FROM QUESTION WHERE part_id = #{partId} ORDER BY `index`")
  List<Question> queryQuestionsByPartId(int partId);

  @Select("SELECT * FROM QUESTION WHERE group_id = #{groupId} ORDER BY `index`")
  List<Question> queryQuestionsByGroupId(int groupId);

  @Select("SELECT(SELECT COUNT(q.id) FROM Question q INNER JOIN Part p ON q.part_id = p.id WHERE q.group_id IS NULL AND p.test_id = #{testId})+(SELECT COUNT(q.id) FROM Question q INNER JOIN Question_Group qg INNER JOIN Part p ON qg.part_id = p.id AND qg.id = q.group_id WHERE q.group_id IS NOT NULL AND p.test_id = #{testId})")
  int queryCountTotalQuestionsByTestId(int testId);

  @Insert("INSERT INTO Question (`index`,part_id,group_id,image_link,question_tittle,correct_answer,correct_answer_id) VALUES (#{index},#{partId},#{groupId},#{imageLink},#{questionTittle},#{correctAnswer},#{correctAnswerId})")
  @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
  void insertQuestion(Question question);

  @Update("UPDATE Question SET part_id=#{partId},group_id=#{groupId},`index`=#{index},image_link=#{imageLink},question_tittle=#{questionTittle},correct_answer=#{correctAnswer},correct_answer_id=#{correctAnswerId} WHERE id=#{id}")
  void updateQuestion(Question question);

  @Delete("DELETE FROM Question WHERE id=#{id}")
  boolean deleteQuestionById(int id);
}
