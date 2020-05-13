package online_toeic_test_springboot.data.mapper;

import online_toeic_test_springboot.domain.model.QuestionGroup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionGroupCRUDMapper {

  @Select("SELECT * FROM QUESTION_GROUP WHERE part_id = #{partId} ORDER BY `index`")
  List<QuestionGroup> queryQuestionGroupsByPartId(int partId);
}
