package online_toeic_test_springboot.infrastructure.mapper;

import online_toeic_test_springboot.domain.model.QuestionGroup;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface QuestionGroupCRUDMapper {

  @Select("SELECT * FROM QUESTION_GROUP WHERE id = #{id}")
  Optional<QuestionGroup> queryQuestionGroupById(int id);

  @Select("SELECT * FROM QUESTION_GROUP WHERE part_id = #{partId} ORDER BY `index`")
  List<QuestionGroup> queryQuestionGroupsByPartId(int partId);

  @Insert("INSERT INTO Question_Group (`index`,part_id,image_link,paragraph,tittle) VALUES (#{index},#{partId},#{imageLink},#{paragraph},#{tittle})")
  @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
  void insertQuestionGroup(QuestionGroup questionGroup);
}