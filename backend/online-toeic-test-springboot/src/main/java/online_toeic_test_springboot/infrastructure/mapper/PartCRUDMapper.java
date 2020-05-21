package online_toeic_test_springboot.infrastructure.mapper;

import online_toeic_test_springboot.domain.model.Part;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PartCRUDMapper {

  @Select("SELECT * FROM PART WHERE id = #{id}")
  Optional<Part> queryPartById(int id);

  @Select("SELECT * FROM PART")
  List<Part> queryAllParts();

  @Select("SELECT * FROM PART WHERE test_id = #{testId}")
  List<Part> queryPartsByTestId(int testId);

  @Select("SELECT * FROM PART WHERE test_id = #{testId} AND part_num = #{partNum}")
  Optional<Part> queryPartByTestIdAndPartNum(int testId, int partNum);

  @Insert("INSERT INTO Part (test_id,part_num,type,tittle,direction) VALUES (#{testId},#{partNum},#{type},#{tittle},#{direction})")
  @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
  void insertPart(Part part);

  @Update("UPDATE Part SET test_id=#{testId},part_num=#{partNum},type=#{type},tittle=#{tittle},direction=#{direction} WHERE id=#{id}")
  void updatePart(Part part);

  @Delete("DELETE FROM Part WHERE id=#{id}")
  boolean deletePartById(int id);
}
