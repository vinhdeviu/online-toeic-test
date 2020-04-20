package online_toeic_test_springboot.service;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * SingleProductOutput.
 */
@Data
@RequiredArgsConstructor
public class AllPartsOutput {

  private final Part1Output part1;
  private final Part2Output part2;
  private final Part3Output part3;
  private final Part4Output part4;
  private final Part5Output part5;
  private final Part6Output part6;
  private final Part7Output part7;
}
