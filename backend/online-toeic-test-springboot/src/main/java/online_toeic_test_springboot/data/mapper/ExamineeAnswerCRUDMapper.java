package online_toeic_test_springboot.data.mapper;

import online_toeic_test_springboot.domain.model.ExamineeAnswer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ExamineeAnswerCRUDMapper {

  @Insert("INSERT INTO examinee_answer (achievement_id,question_id,`option`,answer_id) VALUES (#{achievementId},#{questionId},#{option},#{answerId})")
  void insertExamineeAnswer(ExamineeAnswer examineeAnswer);

  @Select("SELECT * FROM examinee_answer WHERE achievement_id = #{achievementId}")
  List<ExamineeAnswer> queryExamineeAnswersByAchievementId(int achievementId);
}
