package online_toeic_test_springboot.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class QuestionGroup {
    private int id;
    private int partId;
    private int groupId;
    private String audioLink;
    private String paragrapth;
    private int difficulty;
}
