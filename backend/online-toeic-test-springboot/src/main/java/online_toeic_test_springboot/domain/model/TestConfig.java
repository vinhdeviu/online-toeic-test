package online_toeic_test_springboot.domain.model;

import java.util.Arrays;
import java.util.List;

public class TestConfig {
    public static final int TIME_PER_TEST_IN_SECOND = 120*60;
    public static final int TOTAL_PARTS = 7;
    public static final int MAX_NUM_ANSWERS_PER_QUESTION = 4;
    public static final List<Character> ANSWERS_CHAR_VALUES = Arrays.asList('A','B','C','D');
    public static final Character DEFAULT_ANSWER_CHAR_VALUE = 'A';
    public static final int LISTENING_TYPE_INT_VALUE = 1;
    public static final int READING_TYPE_INT_VALUE = 2;
    public static final List<Integer> LISTENING_PARTS = Arrays.asList(1,2,3,4);
    public static final List<Integer> READING_PARTS = Arrays.asList(5,6,7);
    public static final List<Integer> PARTS_WITHOUT_QUESTION_GROUP = Arrays.asList(1,2,3,4,5);
    public static final List<Integer> PARTS_WITH_QUESTION_GROUP = Arrays.asList(6,7);
    public static final List<Integer> PARTS_WITHOUT_ANSWERS_CONTENT = Arrays.asList(1,2);
    public static final List<Integer> PARTS_WITH_ANSWERS_CONTENT = Arrays.asList(3,4,5,6,7);
    public static final List<Integer> SHUFFLE_QUESTION_PARTS = Arrays.asList(5,7);
    public static final List<Integer> SHUFFLE_QUESTION_GROUP_PARTS = Arrays.asList(7);
    public static final List<Integer> SHUFFLE_ANSWER_PARTS = Arrays.asList(3,4,5,6,7);
}
