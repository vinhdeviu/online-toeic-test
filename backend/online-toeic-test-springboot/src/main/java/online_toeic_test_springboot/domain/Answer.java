package online_toeic_test_springboot.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Answer {
    private int id;
    private int questionId;
    private String content;
}
