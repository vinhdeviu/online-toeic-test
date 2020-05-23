package online_toeic_test_springboot.infrastructure.mapper;

import online_toeic_test_springboot.domain.model.QuestionGroup;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface QuestionGroupCRUDMapper {

  @Select("SELECT * FROM QUESTION_GROUP WHERE id = #{id}")
  Optional<QuestionGroup> queryQuestionGroupById(int id);

  @Select("SELECT * FROM QUESTION_GROUP ORDER BY part_id, `index`")
  List<QuestionGroup> queryAllQuestionGroups();

  @Select("SELECT * FROM QUESTION_GROUP WHERE part_id = #{partId} ORDER BY `index`")
  List<QuestionGroup> queryQuestionGroupsByPartId(int partId);

  @Insert("INSERT INTO Question_Group (`index`,part_id,image_link,paragraph,tittle) VALUES (#{index},#{partId},#{imageLink},#{paragraph},#{tittle})")
  @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
  void insertQuestionGroup(QuestionGroup questionGroup);

  @Update("UPDATE Question_Group SET part_id=#{partId},`index`=#{index},image_link=#{imageLink},tittle=#{tittle},paragraph=#{paragraph} WHERE id=#{id}")
  void updateQuestionGroup(QuestionGroup questionGroup);

  @Delete("DELETE FROM Question_Group WHERE id=#{id}")
  boolean deleteQuestionGroupById(int id);
}
