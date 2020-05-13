package online_toeic_test_springboot.domain.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Part {
    private int id;
    private int testId;
    private int partNum;
    private int type;
    private String tittle;
    private String direction;
    private boolean switchable;
    private List<QuestionGroup> questionGroups;
    private List<Question> questions;
}
