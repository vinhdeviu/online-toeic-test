package online_toeic_test_springboot.service;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * SingleProductOutput.
 */
@Data
@RequiredArgsConstructor
public class Part5Output {

  private final String id;
  private final String title;
  private final String description;
  private final Long createdAt;
  private final Long updatedAt;
  private final Long deletedAt;
}
