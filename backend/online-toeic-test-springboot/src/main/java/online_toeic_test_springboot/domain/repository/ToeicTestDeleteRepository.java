package online_toeic_test_springboot.domain.repository;

public interface ToeicTestDeleteRepository {

    void deleteTestById(int id);

    void deletePartById(int id);

    void deleteQuestionGroupById(int id);

    void deleteQuestionById(int id);
}
