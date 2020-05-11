package online_toeic_test_springboot.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class QuestionGroup {
    private int id;
    private String tittle;
    private int partId;
    private String imageLink;
    private String paragraph;
    private boolean switchAble;
    private int index;
    private List<Question> questions;
}
