package online_toeic_test_springboot.data;

import online_toeic_test_springboot.domain.Achievement;
import online_toeic_test_springboot.domain.ExamineeAnswer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AchievementMapper {

  @Insert("INSERT INTO achievement (examinee_id,test_id,date,total_correct_answer) VALUES (#{examineeId},#{testId},#{date},#{totalCorrectAnswer})")
  @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
  void insertAchievement(Achievement achievement);

  @Insert("INSERT INTO examinee_answer (achievement_id,question_id,`option`,answer_id) VALUES (#{achievementId},#{questionId},#{option},#{answerId})")
  void insertExamineeAnswer(ExamineeAnswer examineeAnswer);

  @Select("SELECT a.id, a.examinee_id, a.date, a.total_correct_answer, t.test_name FROM achievement a INNER JOIN test t ON a.test_id = t.id WHERE a.examinee_id = #{examineeId}")
  List<Achievement> queryAchievementByExamineeId(int examineeId);

  @Select("SELECT * FROM achievement WHERE id = #{id}")
  Optional<Achievement> queryAchievementById(int id);

  @Select("SELECT * FROM examinee_answer WHERE achievement_id = #{achievementId}")
  List<ExamineeAnswer> queryExamineeAnswersByAchievementId(int achievementId);
}
