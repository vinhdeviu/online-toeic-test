package online_toeic_test_springboot.domain.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class QuestionGroup {
    private Integer id;
    private String tittle;
    private Integer partId;
    private String imageLink;
    private String paragraph;
    private Integer index;
    private List<Question> questions;
}
