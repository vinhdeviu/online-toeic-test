package online_toeic_test_springboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Achievement {
    private int id;
    private int examineeId;
    private String date;
    private int difficulty;
    private int score;
}
