package online_toeic_test_springboot.data;

import online_toeic_test_springboot.domain.Achievement;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AchievementMapper {

  @Insert("INSERT INTO achievement (examinee_id,date,difficulty,score) VALUES (#{examineeId},#{date},#{difficulty},#{score})")
  void createAchievement(Achievement achievement);

  @Select("SELECT * FROM achievement WHERE examinee_id = #{examineeId}")
  List<Achievement> getAchievementByExamineeId(int examineeId);
}
