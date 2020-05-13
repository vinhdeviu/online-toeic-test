package online_toeic_test_springboot.data.mapper;

import online_toeic_test_springboot.domain.model.Part;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface PartCRUDMapper {

  @Select("SELECT * FROM PART WHERE test_id = #{testId} AND part_num = #{partNum}")
  Optional<Part> queryPartByTestIdAndPartNum(int testId, int partNum);
}
