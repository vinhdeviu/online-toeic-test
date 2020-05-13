package online_toeic_test_springboot.service;

public interface ToeicTestDeleteService {

    void deleteTestById(int id);

    void deletePartById(int id);

    void deleteQuestionGroupById(int id);

    void deleteQuestionById(int id);
}
