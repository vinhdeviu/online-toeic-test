package online_toeic_test_springboot.service;

import online_toeic_test_springboot.domain.TestInfor;

public interface ToeicTestService {

    PartOutput generatePart(int partId, int difficulty);

    TestInfor getTestInfor();
}
