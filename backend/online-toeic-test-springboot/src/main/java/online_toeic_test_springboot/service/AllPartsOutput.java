package online_toeic_test_springboot.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * SingleProductOutput.
 */
@Data
@RequiredArgsConstructor
public class AllPartsOutput {

  private final PartWithQuestionOutput part1;
  private final PartWithQuestionOutput part2;
  private final PartWithQuestionGroupOutput part3;
  private final PartWithQuestionGroupOutput part4;
  private final PartWithQuestionOutput part5;
  private final PartWithQuestionGroupOutput part6;
  private final PartWithQuestionGroupOutput part7;
}
