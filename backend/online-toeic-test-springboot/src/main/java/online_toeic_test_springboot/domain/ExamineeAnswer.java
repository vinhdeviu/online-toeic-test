package online_toeic_test_springboot.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ExamineeAnswer {
    private int id;
    private int achievementId;
    private int questionId;
    private char option;
    private int answerId;
}
