package online_toeic_test_springboot.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Part {
    private Integer id;
    private Integer testId;
    private Integer partNum;
    private Integer type;
    private String tittle;
    private String direction;
    private List<QuestionGroup> questionGroups;
    private List<Question> questions;
}
