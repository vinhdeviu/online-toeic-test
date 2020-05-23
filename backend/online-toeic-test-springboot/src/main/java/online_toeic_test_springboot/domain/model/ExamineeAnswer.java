package online_toeic_test_springboot.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExamineeAnswer {
    private Integer id;
    private Integer achievementId;
    private Integer questionId;
    private Character option;
    private Integer answerId;
}
