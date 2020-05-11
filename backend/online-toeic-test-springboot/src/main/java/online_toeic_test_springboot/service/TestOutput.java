package online_toeic_test_springboot.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import online_toeic_test_springboot.domain.Part;
import online_toeic_test_springboot.domain.Test;

@Data
@AllArgsConstructor
public class TestOutput {

  private Test test;
  private PartWithQuestionOutput part1;
  private PartWithQuestionOutput part2;
  private PartWithQuestionOutput part3;
  private PartWithQuestionOutput part4;
  private PartWithQuestionOutput part5;
  private PartWithQuestionGroupOutput part6;
  private PartWithQuestionGroupOutput part7;
}
