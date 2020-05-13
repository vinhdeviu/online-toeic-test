package online_toeic_test_springboot.domain.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Answer {
    private Integer id;
    private Integer questionId;
    private String content;
}
