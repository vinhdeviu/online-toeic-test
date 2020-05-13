package online_toeic_test_springboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class TestInfor {
    private int timeInSecond;
    private int totalQuestions;
}
