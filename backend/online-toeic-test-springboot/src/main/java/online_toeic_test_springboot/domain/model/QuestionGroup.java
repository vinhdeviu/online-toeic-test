package online_toeic_test_springboot.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuestionGroup {
    private Integer id;
    private String tittle;
    private Integer partId;
    private String imageLink;
    private String paragraph;
    private Integer index;
    private List<Question> questions;
}
