package online_toeic_test_springboot.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TestInfor {
    private Integer timeInSecond;
    private Integer totalQuestions;
}
