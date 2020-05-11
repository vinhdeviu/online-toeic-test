package online_toeic_test_springboot.service;

import online_toeic_test_springboot.domain.Test;
import online_toeic_test_springboot.domain.TestInfor;

import java.util.List;

public interface ToeicTestService {

    List<Test> retrieveAllTests();

    //TestOutput generateTest(int testId);

    Test generateTest(int testId);

    TestInfor getTestInfor();
}
