package online_toeic_test_springboot.data.mapper;

import online_toeic_test_springboot.domain.model.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionCRUDMapper {

  @Select("SELECT * FROM QUESTION WHERE part_id = #{partId} ORDER BY `index`")
  List<Question> queryQuestionsByPartId(int partId);

  @Select("SELECT * FROM QUESTION WHERE group_id = #{groupId} ORDER BY `index`")
  List<Question> queryQuestionsByGroupId(int groupId);
}
