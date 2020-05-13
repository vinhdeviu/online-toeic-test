package online_toeic_test_springboot.domain.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ExamineeAnswer {
    private Integer id;
    private Integer achievementId;
    private Integer questionId;
    private Character option;
    private Integer answerId;
}
