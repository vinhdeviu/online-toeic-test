package online_toeic_test_springboot.service;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * SingleProductOutput.
 */
@Data
@RequiredArgsConstructor
public class Part1Output {

  private final String partTittle;
  private final List<Question> questions;
}
